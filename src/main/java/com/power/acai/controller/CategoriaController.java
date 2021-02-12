package com.power.acai.controller;

import java.util.Arrays;
import java.util.Optional;

import com.power.acai.model.Categoria;
import com.power.acai.service.CategoriaService;
import com.power.acai.util.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/")
    public String helloWorld() {
        return "HelloWorld";
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Response<Categoria>> cadastrar(@RequestBody Categoria categoria) {
        Categoria c = categoriaService.save(categoria);
        Response<Categoria> response = new Response<>();
        if (c != null) {
            response.setData(c);
            return ResponseEntity.ok(response);
        } else {
            response.setErrors(Arrays.asList("Nao foi possivel salvar o produto"));
            return ResponseEntity.badRequest().body(response);
        }
    }

}
