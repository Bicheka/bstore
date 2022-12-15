package com.bicheka.bstore.web;

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

    @GetMapping("/{user_id}")
    public ResponseEntity<User> getUser(@PathVariable Long user_id){
        return new ResponseEntity<>(userService.getUser(user_id), HttpStatus.OK);
    }

    @PostMapping("/add_user")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/{user_id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable Long user_id) {
        userService.deleteUser(user_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/shoppingcart/{user_id}")
    public ResponseEntity<List<Item>>getShoppingCart(@PathVariable long user_id){
        return new ResponseEntity<>(userService.getShoppingCart(user_id), HttpStatus.OK);
    }

    @PutMapping("/add_to_cart/{user_id}")
    public ResponseEntity<List<Item>> addItemToCart(@PathVariable long user_id, @RequestBody Item item) {
        return new ResponseEntity<>(userService.addItemToCart(user_id, item), HttpStatus.CREATED);
    }

    @PutMapping("/remove_from_cart/{user_id}-{item_id}")
    public ResponseEntity<HttpStatus> removeFromShoppingCart(@PathVariable long user_id, @PathVariable long item_id) {
        userService.removeItemFromCart(user_id, item_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/clear_cart/{user_id}")
    public ResponseEntity<HttpStatus> cleanShoppingCart(@PathVariable long user_id) {
        userService.clearShoppingCart(user_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/purchase_cart_items/{user_id}")
    public ResponseEntity<Double> purchaseShoppingCartItems(@PathVariable long user_id){
        return new ResponseEntity<>(userService.purchaseShoppingCartItems(user_id), HttpStatus.CREATED);
    }
}
