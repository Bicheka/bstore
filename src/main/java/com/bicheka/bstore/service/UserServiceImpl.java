package com.bicheka.bstore.service;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bicheka.bstore.entity.Item;
import com.bicheka.bstore.entity.User;
import com.bicheka.bstore.exception.UserNotFoundException;
import com.bicheka.bstore.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    ItemService itemService;

    @Override
    public User getUser(long id) {
        Optional<User> user = userRepository.findById(id);
        
        return unwrapUser(user, id);
    }

    static User unwrapUser(Optional<User> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new UserNotFoundException(id);
    }

    @Override 
    public User saveUser(User user){
        return userRepository.save(user);
    }
    
    @Override
    public void deleteUser(long id){
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public Stack<Item> addItemToCart(long userId, Item item){

        Stack<Item> cart = new Stack<>();
        List<Item> list = getUser(userId).getCart();

        for(Item i : list){
            cart.push(i);
        }
        cart.push(item);
        getUser(userId).setCart(cart);
        return cart;
    }
    
    @Override
    public void removeItemFromCart(long userId, long itemId){
        Stack<Item> cart = getUser(userId).getCart();
        for (Item i : cart) {
            if(i.getId()==itemId);
            cart.remove(i);
        }
        getUser(userId).setCart(cart);
    }

    @Override
    public Stack<Item> getShoppingCart(long userId){
        return getUser(userId).getCart();
    }
    
    @Override
    public double purchaseShoppingCartItems(long userId){
        Stack<Item> list = getUser(userId).getCart();

        double total = 0;
        for (Item i : list) {
            //reduce the amount in stock of every item bought by 1 
            //in a future update the user will be able to buy more than 1 at once
            long itemId = i.getId();
            long amount = itemService.getItem(userId).getAmountInStock();
            itemService.getItem(itemId).setAmountInStock(amount-1);
            //clear shopping cart
            clearShoppingCart(userId);

            total += i.getItemPrice();//add up to know the total cost of the purchase 
        }
        return total;
    }

    @Override
    public void clearShoppingCart(long userId){
        Stack<Item> list = getUser(userId).getCart();
        for (Item i : list) {
            list.remove(i);
        }
        getUser(userId).setCart(list);
    }
}
