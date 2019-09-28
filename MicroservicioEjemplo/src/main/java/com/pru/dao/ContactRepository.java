package com.pru.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pru.dto.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

}
