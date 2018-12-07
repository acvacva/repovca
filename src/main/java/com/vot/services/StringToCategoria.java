package com.vot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.vot.model.Categoria;
import com.vot.repository.CategoriaRepository;



@Component
public class StringToCategoria implements Converter<String, Categoria> {

@Autowired
private CategoriaRepository repository; //Or the class that implments the repository.

/* @Override
    public Categoria convert(String arg0) {
        Integer id = new Integer(arg0);
        return repository.findOne(id);
    }*/

   @Override
    public Categoria convert(String arg0) {
        
        return repository.findByNombrecategoria(arg0);
    }
    
    /* @Override
    public Categoria convert(String arg0) {
        
        if (repository.findByNombrecategoria(arg0) != null)
        
        return repository.findByNombrecategoria(arg0);
        
        else {
        	
        	Integer id = new Integer(arg0);
            return repository.findOne(id);
        	
        }
        
        
    }*/

}