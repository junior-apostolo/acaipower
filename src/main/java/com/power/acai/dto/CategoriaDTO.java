package com.power.acai.dto;

import java.io.Serializable;

import com.power.acai.model.Categoria;

public class CategoriaDTO implements Serializable {

    private Integer id;

    private String descricao;

    public CategoriaDTO() {

    }

    public CategoriaDTO(Categoria obj) {
        this.id = obj.getId();
        this.descricao = obj.getDescricao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return descricao;
    }

    public void setNome(String nome) {
        this.descricao = nome;
    }
}
    