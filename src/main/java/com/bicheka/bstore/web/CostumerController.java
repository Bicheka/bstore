package com.bicheka.bstore.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bicheka.bstore.entity.Costumer;
import com.bicheka.bstore.entity.Item;
import com.bicheka.bstore.service.CostumerService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/costumer")
public class CostumerController {
    
    @Autowired
    CostumerService costumerService;

    @PostMapping
    public ResponseEntity<Costumer> saveCostumer(@RequestBody Costumer costumer) {
        return new ResponseEntity<>(costumerService.saveCostumer(costumer), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Costumer> getCostumer(@PathVariable long id){
        return new ResponseEntity<>(costumerService.getCostumer(id), HttpStatus.OK);
    }

    @DeleteMapping("/deletecostumer/{id}")
    public ResponseEntity<HttpStatus> deleteCostumer(@PathVariable Long id) {
        costumerService.deleteCostumer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/shoppingcart/{id}")
    public ResponseEntity<ArrayList<Item>>getShoppingCart(@PathVariable long id){
        return new ResponseEntity<>(costumerService.getShoppingCart(id), HttpStatus.OK);
    }

    @PostMapping("/add_to_cart")
    public ResponseEntity<ArrayList<Item>> addItemToCart(@RequestBody long id, Item item) {
        return new ResponseEntity<>(costumerService.addItemToCart(id, item), HttpStatus.CREATED);
    }

    @PutMapping("/remove_from_cart/{id}-{index}")
    public ResponseEntity<HttpStatus> removeFromShoppingCart(@PathVariable long id, @PathVariable int index) {
        costumerService.removeFromShoppingCart(id, index);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/clear_cart/{id}")
    public ResponseEntity<HttpStatus> cleanShoppingCart(@PathVariable long id) {
        costumerService.clearShoppingCart(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/purchase_cart_items/{id}")
    public ResponseEntity<Double> purchaseShoppingCartItems(@PathVariable long id){
        return new ResponseEntity<>(costumerService.purchaseShoppingCartItems(id), HttpStatus.CREATED);
    }
}
