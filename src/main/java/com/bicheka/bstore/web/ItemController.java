package com.bicheka.bstore.web;

import java.util.Stack;

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
import com.bicheka.bstore.service.ItemService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/item")
public class ItemController {
    
    @Autowired
    ItemService itemService;

    @GetMapping("/{id}")
    public ResponseEntity<Item> getUser(@PathVariable long id){
        return new ResponseEntity<>(itemService.getItem(id), HttpStatus.OK);
    }

    
    @PostMapping("/addItem")
    public ResponseEntity<Item> saveUser(@RequestBody Item item) {
        return new ResponseEntity<>(itemService.addItem(item), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search/{itemName}")
    public Stack<Item> searchItem(@PathVariable String itemName){
        return itemService.searchItem(itemName);
    }

    @PutMapping("/reduceamount/{id}-{amount}")
    public Item reduceAmountInStock(@PathVariable long id, @PathVariable long amount) {
        itemService.reduceAmountInStock(id, amount);
        return itemService.getItem(id);
    }
    
}
