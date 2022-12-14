package com.bicheka.bstore.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bicheka.bstore.entity.Costumer;
import com.bicheka.bstore.entity.Item;
import com.bicheka.bstore.exception.CostumerNotFoundException;
import com.bicheka.bstore.repository.CostumerRepository;

import lombok.AllArgsConstructor;

@Service @AllArgsConstructor
public class CostumerServiceImpl implements CostumerService {

    @Autowired
    CostumerRepository costumerRepository;

    @Autowired
    ItemService itemService;

    @Autowired
    SellerService sellerService;

    public Costumer saveCostumer(Costumer costumer){
        return costumerRepository.save(costumer);
    }

    @Override
    public Costumer getCostumer(long id) {

        Optional<Costumer> costumer = costumerRepository.findById(id);
        
        return unwrapCostumer(costumer, id);

    }
    static Costumer unwrapCostumer(Optional<Costumer> entity, long id) {
        if (entity.isPresent()) return entity.get();
        else throw new CostumerNotFoundException(id);
    }


    @Override
    public void deleteCostumer(long id){
        costumerRepository.deleteById(id);
    }


    @Override
    public ArrayList<Item> getShoppingCart(long id){
        return getCostumer(id).getShoppingCart();
    }

    @Override
    public ArrayList<Item> addItemToCart(long id, Item item){
        ArrayList<Item> list = getCostumer(id).getShoppingCart();
        list.add(item);
        getCostumer(id).setShoppingCart(list);
        return list;
    }

    @Override
    public void removeFromShoppingCart(long id, int index){
        ArrayList<Item> list = getCostumer(id).getShoppingCart();
        list.remove(index);
        getCostumer(id).setShoppingCart(list);
    }
    
    @Override
    public void clearShoppingCart(long id){
        ArrayList<Item> list = getCostumer(id).getShoppingCart();
        for (Item i : list) {
            list.remove(i);
        }
    }
    
    @Override
    public double purchaseShoppingCartItems(long id){
        ArrayList<Item> list = getCostumer(id).getShoppingCart();

        double total = 0;
        for (Item i : list) {
            //reduce the amount in stock of every item bought by 1 
            //in a future update the user will be able to buy more than 1 at once
            id = i.getId();
            long amount = itemService.getItem(id).getAmountInStock();
            itemService.getItem(id).setAmountInStock(amount-1);

            sellerService.increaseMoneyMade(id, itemService.getItem(id).getItemPrice());

            //clear shopping cart
            clearShoppingCart(id);

            total += i.getItemPrice();//add up to know the total cost of the purchase 
        }
        return total;
    }
}
