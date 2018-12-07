package com.vot.services;

import java.util.List;

import com.vot.model.Comentario;
import com.vot.model.Producto;
import com.vot.repository.ListMasComentados;

public interface ComentariosService {

Iterable<Comentario> listAllComentarios();
Comentario getComentarioById(Integer id);
Comentario saveComentario(Comentario comentario);
void deleteComentario(Integer id);
public Iterable<Comentario> findAllByOrderByFechaDesc();
public java.util.List<Object[]> masComentados();
public java.util.List<Object[]> masValorado();



}