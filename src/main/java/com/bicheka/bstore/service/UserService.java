package com.bicheka.bstore.service;

import com.bicheka.bstore.entity.User;
import java.util.List;

public interface UserService {
    User getUser(Long id);
    User saveUser(User user);
    void deleteUser(Long id);
    List<User> getAllUsers();
}
