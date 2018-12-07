package com.vot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.vot.model.Marca;
import com.vot.repository.MarcaRepository;


@Component
public class StringToMarca implements Converter<String, Marca> {

@Autowired
private MarcaRepository repository; //Or the class that implments the repository.

/*  @Override
    public Marca convert(String arg0) {
        Integer id = new Integer(arg0);
        return repository.findOne(id);
    }*/


 @Override
public Marca convert(String arg0) {

    return repository.findByNombremarca(arg0);
}

/*@Override
public Marca convert(String arg0) {

	
	if (repository.findByNombremarca(arg0) != null)
		
    return repository.findByNombremarca(arg0);
	
	else {
    	
    	Integer id = new Integer(arg0);
        return repository.findOne(id);
    	
    }
}*/
}