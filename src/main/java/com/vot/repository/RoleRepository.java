package com.vot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vot.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
