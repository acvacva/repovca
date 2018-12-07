package com.vot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vot.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
