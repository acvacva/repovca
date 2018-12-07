package com.vot.repository;

import org.springframework.data.repository.CrudRepository;

import com.vot.model.Marca;

public interface MarcaRepository extends CrudRepository<Marca, Integer> {
	
	Marca findByNombremarca(String nombremarca);

}
