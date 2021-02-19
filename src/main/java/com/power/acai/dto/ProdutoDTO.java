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

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public BigDecimal getValor() {
            return valor;
        }

        public void setValor(BigDecimal valor) {
            this.valor = valor;
        }
    
 
}
