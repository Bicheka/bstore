package com.bicheka.bstore.service;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bicheka.bstore.entity.Item;
import com.bicheka.bstore.exception.ItemNotFoundException;
import com.bicheka.bstore.repository.ItemRepository;

import lombok.AllArgsConstructor;

@Service @AllArgsConstructor
public class ItemServiceImpl implements ItemService {
    
    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    @Override
    public Item getItem(long id) {
        Optional<Item> user = itemRepository.findById(id);
        return unwrapItem(user, id);
    }
    static Item unwrapItem(Optional<Item> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new ItemNotFoundException(id);
    }

    @Override
    public Item addItem(Item item){
        return itemRepository.save(item);
    }

    @Override
    public void deleteItem(long id){
        itemRepository.deleteById(id);
    }

    @Override
    public Item reduceAmountInStock(long id, long amount){
        long itemAmount = getItem(id).getAmountInStock();
        getItem(id).setAmountInStock(itemAmount-amount);
        return getItem(id);
    }

    @Override
    public Stack<Item> searchItem(String itemName){
        Stack<Item> items = new Stack<>();
        List<Item> list = itemRepository.findAll();
        for(Item i : list){
            if(i.getItemName().contains(itemName)){
                items.push(i);
            }
        }
        return items;
    }

}
