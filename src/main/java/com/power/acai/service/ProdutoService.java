package com.power.acai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.power.acai.model.Categoria;
import com.power.acai.model.Produto;
import com.power.acai.repository.CategoriaRepository;
import com.power.acai.repository.ProdutoRepository;
import com.power.acai.util.exception.ObjectNotFoundException;

import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Produto findById(Integer id) throws ObjectNotFoundException {
        Optional<Produto> obj = produtoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id +
                ", Tipo: " + Produto.class.getName()));
    }

    // public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction){
    //     PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
    //     List<Categoria> categoriasList = categoriaRepository.findAllById(ids);

    //     return produtoRepository.findDistinctByNomeContainingAndCategoriasIn(nome, categoriasList, pageRequest);
    // }
}