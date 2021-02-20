package com.power.acai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.power.acai.model.Categoria;
import com.power.acai.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

	public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
	}

	public Optional<Categoria> findById(int i) {
		return categoriaRepository.findById(i);
	}

	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	public void delete(Optional<Categoria> opCategoria) {
		categoriaRepository.delete(opCategoria.get());
	}

	public Categoria atualizarCategoria(Categoria categoria) {
		Optional<Categoria> cat = categoriaRepository.findById(categoria.getId());

		if(cat.isPresent()){
			Categoria c = categoriaRepository.save(categoria);
			return c;
		} else {
			return null;
		}
	}
}
