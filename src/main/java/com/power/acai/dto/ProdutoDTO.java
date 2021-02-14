package com.power.acai.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.power.acai.model.Produto;

public class ProdutoDTO implements Serializable {

        private Integer id;
        private String descricao;
        private BigDecimal valor;
    
        public ProdutoDTO(){
    
        }
    
        public ProdutoDTO(Produto obj){
            this.id = obj.getId();
            this.descricao = obj.getDescricao();
            this.valor = obj.getValor();
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
    
        public BigDecimal getPreco() {
            return valor;
        }
    
        public void setPreco(BigDecimal preco) {
            this.valor = preco;
        }
}
