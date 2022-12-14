package com.bicheka.bstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bicheka.bstore.entity.Item;
import com.bicheka.bstore.entity.Seller;
import com.bicheka.bstore.exception.SellerNotFoundException;
import com.bicheka.bstore.repository.ItemRepository;
import com.bicheka.bstore.repository.SellerRepository;

import lombok.AllArgsConstructor;

@Service @AllArgsConstructor
public class SellerServiceImpl implements SellerService{

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    ItemRepository itemRepository;
    
    @Override
    public Seller saveSeller(Seller seller){
        return sellerRepository.save(seller);
    }

    @Override
    public Seller getSeller(long id) {
        Optional<Seller> seller = sellerRepository.findById(id);
        return unwrapSeller(seller, id);
    }
    static Seller unwrapSeller(Optional<Seller> entity, long id) {
        if (entity.isPresent()) return entity.get();
        else throw new SellerNotFoundException(id);
    }

    @Override
    public void deleteSeller(long id){
        sellerRepository.deleteById(id);
    }

    @Override
    public ArrayList<Item> addItemToMarket(long id, Item item){
        
        //add items to the seller list of products on market
        ArrayList<Item> items = getSeller(id).getProductsOnMarket();
        items.add(item);
        getSeller(id).setProductsOnMarket(items);

        //save item to the items repository which will be the global market
        itemRepository.save(item);

        return items;
    }

    @Override
    public ArrayList<Item> getProductsOnMarket(long id){//get the products this seller has put on the market
        return getSeller(id).getProductsOnMarket();
    }

    @Override
    public void removeItemFromMarket(long id, int index){
        //delte from the seller's items on market list
        ArrayList<Item> list = getSeller(id).getProductsOnMarket();
        list.remove(index);
        getSeller(id).setProductsOnMarket(list);

        //delete from the items repository
        itemRepository.deleteById(id);
    }

    @Override
    public void removeAllItemsFromMarket(long id){
        List<Item> list = getSeller(id).getProductsOnMarket();
        for (Item i : list) {
            list.remove(i);
        }
    }

    @Override 
    public void increaseMoneyMade(long id, double amount){
        double money = getSeller(id).getMoneyMade();
        money +=amount;
        getSeller(id).setMoneyMade(money);
    }
}
