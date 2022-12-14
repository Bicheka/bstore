package com.bicheka.bstore.service;

import java.util.ArrayList;

import com.bicheka.bstore.entity.Item;
import com.bicheka.bstore.entity.Seller;

public interface SellerService {
    //id refers to the seller id
    Seller saveSeller(Seller seller);
    Seller getSeller(long id);
    void deleteSeller(long id);
    ArrayList<Item> getProductsOnMarket(long id);
    ArrayList<Item> addItemToMarket(long id, Item item);//seller id, item
    void removeItemFromMarket(long id, int index);
    void removeAllItemsFromMarket(long id);
    void increaseMoneyMade(long id, double amount);
}

