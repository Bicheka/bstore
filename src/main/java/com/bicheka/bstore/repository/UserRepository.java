package com.bicheka.bstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bicheka.bstore.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
