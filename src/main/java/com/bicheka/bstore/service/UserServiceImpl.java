package com.bicheka.bstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bicheka.bstore.entity.User;
import com.bicheka.bstore.exception.UserNotFoundException;
import com.bicheka.bstore.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        
        return unwrapUser(user, id);

       //return userRepository.getReferenceById(id);
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
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
