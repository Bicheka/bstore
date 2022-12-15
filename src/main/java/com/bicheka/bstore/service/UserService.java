package com.bicheka.bstore.service;

import com.bicheka.bstore.entity.Item;
import com.bicheka.bstore.entity.User;

import java.util.List;
import java.util.Stack;

public interface UserService {
    User getUser(long userId);
    User saveUser(User user);
    void deleteUser(long userId);
    List<User> getAllUsers();
    
    Stack<Item> addItemToCart(long userId, Item item);
    void removeItemFromCart(long userId, long itemId);
    Stack<Item> getShoppingCart(long userId);
    double purchaseShoppingCartItems(long userId);
    void clearShoppingCart(long userId);
}
