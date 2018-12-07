package com.vot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.vot.model.Comentario;
import com.vot.repository.ComentariosRepository;
import com.vot.repository.ListMasComentados;

@Service
public class ComentariosServiceImpl implements ComentariosService {

	@Autowired
	private ComentariosRepository comentariosrepository;
	
	@Override
	public Iterable<Comentario> listAllComentarios(){
		return comentariosrepository.findAll();
	}
	
	@Override
	public Iterable<Comentario> findAllByOrderByFechaDesc(){
		return comentariosrepository.findAllByOrderByFechaDesc();
	}
	
	
	
	@Override
	public Comentario getComentarioById(Integer id) {
		return comentariosrepository.findOne(id);
	}
	
	@Override
	public Comentario saveComentario(Comentario comentario) {
		
		return comentariosrepository.save(comentario);
	};
	
	
	@Override
	public void deleteComentario(Integer id) {
		comentariosrepository.delete(id);
	};
	
		
	@Override
	@Cacheable("coment")
	public java.util.List<Object[]> masComentados(){
		
		return comentariosrepository.masComentados();
	};
	
	@Override
	public java.util.List<Object[]> masValorado(){
		
		return comentariosrepository.masValorado();
	};
	
	
	
	

}
