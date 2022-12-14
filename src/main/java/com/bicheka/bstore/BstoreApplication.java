package com.bicheka.bstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bicheka.bstore.repository.CostumerRepository;
import com.bicheka.bstore.repository.ItemRepository;
import com.bicheka.bstore.repository.SellerRepository;

@SpringBootApplication
public class BstoreApplication {

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	CostumerRepository costumerRepository;

	@Autowired
	SellerRepository sellerRepository;
 
	public static void main(String[] args) {
		SpringApplication.run(BstoreApplication.class, args);
	}

}
