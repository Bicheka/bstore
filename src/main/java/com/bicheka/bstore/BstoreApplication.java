package com.bicheka.bstore;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bicheka.bstore.repository.ItemRepository;
import com.bicheka.bstore.repository.UserRepository;

//import com.bicheka.bstore.entity.User;
//import com.bicheka.bstore.repository.UserRepository;

@SpringBootApplication
public class BstoreApplication {

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(BstoreApplication.class, args);
	}

}
