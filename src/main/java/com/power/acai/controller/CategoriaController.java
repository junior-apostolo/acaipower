package com.power.acai.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.power.acai.model.Categoria;
import com.power.acai.service.CategoriaService;
import com.power.acai.util.Response;




@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/")
    public String helloWorld() {
        return "HelloWorld";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/cadastrar")
    public ResponseEntity<Response<Categoria>> cadastrar(@RequestBody Categoria categoria) {
        Categoria c = categoriaService.save(categoria);
        Response<Categoria> response = new Response<>();
        if (c != null) {
            response.setData(c);
            return ResponseEntity.ok(response);
        } else {
            response.setErrors(Arrays.asList("Nao foi possivel salvar a categoria"));
            return ResponseEntity.badRequest().body(response);
        }
    }


    @GetMapping()
    public ResponseEntity<Response<List<Categoria>>> findAll() {
        List<Categoria> categorias = categoriaService.findAll();
        Response<List<Categoria>> response = new Response<>();
        if(!categorias.isEmpty() && categorias != null) {
            response.setData(categorias);
            return ResponseEntity.ok().body(response);
        }else {
            response.setErrors(Arrays.asList("Não existe categorias cadastradas"));
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Categoria>> findByCategoria(@PathVariable Integer id) {
        Optional<Categoria> categoria = categoriaService.findById(id);
        Response<Categoria> response = new Response<>();
        if (categoria.isPresent()) {
            response.setData(categoria.get());
            return ResponseEntity.ok().body(response);
        } else {
            response.setErrors(Arrays.asList("Categoria não encontrada"));
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Response<String>> deletarCategoria(@PathVariable Integer id) {
        Optional<Categoria> opCategoria = categoriaService.findById(id);
        Response<String> response = new Response<>();

        if(opCategoria.isPresent() && opCategoria != null) {
            categoriaService.delete(opCategoria);
            response.setData("Categoria " + opCategoria.get().getDescricao() + " excluida com sucesso");
            return ResponseEntity.ok().body(response);
        }else {
            response.setErrors(Arrays.asList("Categoria " + opCategoria.get().getDescricao() + " não encontrada"));
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping()
    public ResponseEntity<Response<Categoria>> atualizarCategoria(@RequestBody Categoria categoria){
        Categoria cat = categoriaService.atualizarCategoria(categoria);
        Response<Categoria> response = new Response<>();

        if(cat != null) {
            response.setData(cat);
            return ResponseEntity.ok().body(response);
        } else {
            response.setErrors(Arrays.asList("Categoria " + categoria.getDescricao() + " não atualizada"));
            return ResponseEntity.badRequest().body(response);
        }
    }
}
