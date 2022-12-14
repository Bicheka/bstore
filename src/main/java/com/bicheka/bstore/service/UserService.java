package com.bicheka.bstore.service;

import com.bicheka.bstore.entity.Item;
import com.bicheka.bstore.entity.User;

import java.util.ArrayList;
import java.util.List;

public interface UserService {
    User getUser(long userId);
    User saveUser(User user);
    void deleteUser(long userId);
    List<User> getAllUsers();
    ArrayList<Item> addItemToCart(long userId, Item item);
    void removeItemFromCart(long userId, long itemId);
    ArrayList<Item> getShoppingCart(long userId);
    double purchaseShoppingCartItems(long userId);
    void clearShoppingCart(long userId);
}
