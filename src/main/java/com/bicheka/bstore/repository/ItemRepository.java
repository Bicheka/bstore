package com.bicheka.bstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bicheka.bstore.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
    
}
