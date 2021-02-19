package com.power.acai.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.power.acai.model.Categoria;
import com.power.acai.model.Produto;
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    /*@Transactional(readOnly=true)
    @Query("select distinct obj from Produto obj inner join obj.categorias cat where obj.nome like %:nome% and cat in" +
            " :categoriasList")
    Page<Produto> search(@Param("nome") String nome, @Param("categoriasList") List<Categoria> categoriasList,
                         Pageable pageRequest);*/


    //Esse metodo de pesquisa faz a mesma coisa do "SEARCH" feito encima, só que utilizando os Data query do jpa
    // @Transactional(readOnly=true)
    // Page<Produto> findDistinctByDescricaoContainingAndCategoriasIn(String descricao, List<Categoria> categoriasList, Pageable pageRequest);
}