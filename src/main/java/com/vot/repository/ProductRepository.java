package com.vot.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vot.model.Categoria;
import com.vot.model.Marca;
import com.vot.model.Producto;


@Transactional
public interface ProductRepository extends CrudRepository<Producto, Integer> {
	
	@Query("select e from Marca e ")
	Iterable<Marca> listAllMarcas();

	@Query("select e from Categoria e ")
	Iterable<Categoria> listAllCategorias();
	
	
	Iterable<Producto> findByNombreproducto(String nombreproducto);
	Iterable<Producto> findByMarca(Marca marca);
	Iterable<Producto> findByCategoria(Categoria categoria);
	Iterable<Producto> findByNombreproductoAndMarca(String nombreproducto,Marca marca);
	Iterable<Producto> findByNombreproductoAndCategoria(String nombreproducto,Categoria categoria);
	Iterable<Producto> findByMarcaAndCategoria(Marca marca,Categoria categoria);
	Iterable<Producto> findByNombreproductoAndMarcaAndCategoria(String nombreproducto,Marca marca,Categoria categoria);
	
}
