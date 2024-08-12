package com.workintech.ecommerce_backend.service;

import com.workintech.ecommerce_backend.entity.Store;
import com.workintech.ecommerce_backend.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAllUsers();
    User getUserById(long id);
    User saveUser(User user);
    User saveUserWithStore(User user, Store store);
    void deleteUser(long id);
    User updateUser(long id, User user);
}
