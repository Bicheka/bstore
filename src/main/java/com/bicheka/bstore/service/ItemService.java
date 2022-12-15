package com.bicheka.bstore.service;

import java.util.List;
import java.util.Stack;

import com.bicheka.bstore.entity.Item;

public interface ItemService {
    List<Item> getAllItems();
    Item getItem(long id);
    Item addItem(Item item);
    void deleteItem(long id);
    Item reduceAmountInStock(long id, long amount);
    Stack<Item> searchItem(String itemName);
}
