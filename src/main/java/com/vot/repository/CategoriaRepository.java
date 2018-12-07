package com.vot.repository;

import org.springframework.data.repository.CrudRepository;

import com.vot.model.Categoria;
import com.vot.model.Marca;

public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {
 
	Categoria findByNombrecategoria(String nombrecategoria);
}
