package com.bicheka.bstore.web;

import java.util.ArrayList;
import java.util.List;

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
import com.bicheka.bstore.entity.User;
import com.bicheka.bstore.service.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    
    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    @PostMapping("/add_user")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/shoppingcart/{id}")
    public ResponseEntity<ArrayList<Item>>getShoppingCart(@PathVariable long userId){
        return new ResponseEntity<>(userService.getShoppingCart(userId), HttpStatus.OK);
    }

    @PostMapping("/add_to_cart/{userid}")
    public ResponseEntity<ArrayList<Item>> addItemToCart(@PathVariable long userid, @RequestBody Item item) {
        return new ResponseEntity<>(userService.addItemToCart(userid, item), HttpStatus.CREATED);
    }

    @PutMapping("/remove_from_cart/{id}-{index}")
    public ResponseEntity<HttpStatus> removeFromShoppingCart(@PathVariable long userId, @PathVariable long itemId) {
        userService.removeItemFromCart(userId, itemId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/clear_cart/{id}")
    public ResponseEntity<HttpStatus> cleanShoppingCart(@PathVariable long userId) {
        userService.clearShoppingCart(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/purchase_cart_items/{id}")
    public ResponseEntity<Double> purchaseShoppingCartItems(@PathVariable long userId){
        return new ResponseEntity<>(userService.purchaseShoppingCartItems(userId), HttpStatus.CREATED);
    }
}
