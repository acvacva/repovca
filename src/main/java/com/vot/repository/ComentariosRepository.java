package com.vot.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vot.model.Comentario;



@Transactional
public interface ComentariosRepository extends CrudRepository<Comentario, Integer> {

/*	@Query("select c from Comentario c where c.user = ?1")
	Iterable<Comentario> findByProducto(User user);*/

	public Iterable<Comentario> findAllByOrderByFechaDesc();
	

		
	@Query("Select c.producto.nombreproducto,count(c.producto) from Comentario c  group by c.producto order by count(c.producto) desc")
	  List<Object[]> masComentados();
	
	
	  @Query("Select c.producto.nombreproducto,sum(c.raiting),sum(c.compraragain) from Comentario c   group by c.producto order by count(c.raiting) desc")
	  List<Object[]> masValorado();



}
