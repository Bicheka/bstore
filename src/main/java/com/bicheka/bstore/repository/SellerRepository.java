package com.bicheka.bstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bicheka.bstore.entity.Seller;

public interface SellerRepository extends JpaRepository<Seller,Long>{
    
}
