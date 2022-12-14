package com.bicheka.bstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bicheka.bstore.entity.Costumer;

public interface CostumerRepository extends JpaRepository<Costumer,Long> {
    
}
