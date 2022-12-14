package com.bicheka.bstore.service;

import java.util.Stack;

import com.bicheka.bstore.entity.Item;

public interface ItemService {
    Item getItem(long id);
    Item reduceAmountInStock(long id, long amount);
    Stack<Item> searchItem(String itemName);
}
