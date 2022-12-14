package com.bicheka.bstore.service;

import java.util.ArrayList;

import com.bicheka.bstore.entity.Costumer;
import com.bicheka.bstore.entity.Item;

public interface CostumerService {
    Costumer saveCostumer(Costumer costumer);
    Costumer getCostumer(long id);
    void deleteCostumer(long id);
    ArrayList<Item> getShoppingCart(long id);
    ArrayList<Item> addItemToCart(long id, Item item); //costumer id, item
    void removeFromShoppingCart(long id, int index);
    void clearShoppingCart(long id);
    double purchaseShoppingCartItems(long id);
}
