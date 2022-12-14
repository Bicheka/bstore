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

import com.bicheka.bstore.entity.Item;
import com.bicheka.bstore.entity.Seller;
import com.bicheka.bstore.service.SellerService;


import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @PostMapping
    public ResponseEntity<Seller> saveSeller(@RequestBody Seller seller) {
        return new ResponseEntity<>(sellerService.saveSeller(seller), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seller> getSeller(@PathVariable long id){
        return new ResponseEntity<>(sellerService.getSeller(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete_seller/{id}")
    public ResponseEntity<HttpStatus> deleteseller(@PathVariable Long id) {
        sellerService.deleteSeller(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/products_on_market/{id}")
    public ResponseEntity<ArrayList<Item>>getShoppingCart(@PathVariable long id){
        return new ResponseEntity<>(sellerService.getProductsOnMarket(id), HttpStatus.OK);
    }

    @PostMapping("/add_to_market")
    public ResponseEntity<ArrayList<Item>> addItemToCart(@RequestBody long id, Item item) {
        return new ResponseEntity<>(sellerService.addItemToMarket(id, item), HttpStatus.CREATED);
    }

    @PutMapping("/remove_from_market/{id}-{index}")
    public ResponseEntity<HttpStatus> removeFromShoppingCart(@PathVariable long id, @PathVariable int index) {
        sellerService.removeItemFromMarket(id, index);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/remove_all_from_market/{id}")
    public ResponseEntity<HttpStatus> cleanShoppingCart(@PathVariable long id) {
        sellerService.removeAllItemsFromMarket(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
