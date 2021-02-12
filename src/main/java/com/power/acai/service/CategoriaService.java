package com.power.acai.service;

import java.util.Optional;

import com.power.acai.model.Categoria;
import com.power.acai.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

	public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
	}




}
