package com.pru.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pru.dto.Contact;
import com.pru.service.ContactService;


@RestController
public class ContactsApi {
	
	
	@Autowired
	ContactService contactService;
	
	
    @RequestMapping(value="/contact", method=RequestMethod.GET)
	public Contact getById(){
        return new Contact(1L, "John", "Doe", "+57 311 222 3344", "john@sinbugs.com");
    }
    
    
    
    
    
    
    
    @RequestMapping(value="/contact", method=RequestMethod.POST)
    
  //@RequestBody  Esta anotación indica que la variable debe ser creada con los valores que lleguen en el cuerpo de la petición HTTP, para lo cual usaremos 
    public Contact updateOrSave(@RequestBody Contact contact){
        
        return contactService.save(contact);
    }
    
    
    
    
    
    

}
