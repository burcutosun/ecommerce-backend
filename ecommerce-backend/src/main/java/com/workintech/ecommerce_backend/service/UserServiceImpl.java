package com.workintech.ecommerce_backend.service;

import com.workintech.ecommerce_backend.entity.Store;
import com.workintech.ecommerce_backend.entity.User;
import com.workintech.ecommerce_backend.exception.UserAlreadyExistsException;
import com.workintech.ecommerce_backend.exception.UserNotFoundException;
import com.workintech.ecommerce_backend.repo.StoreRepository;
import com.workintech.ecommerce_backend.repo.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final StoreRepository storeRepository;

    @Override
    public List<User> getAllUsers() {
        List<User> users=userRepository.findAll();
        if(users.isEmpty()){
            throw new UserNotFoundException("No users found");
        }
        return users;
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User not found with id: " + id));
    }

    @Override
    public User saveUser(User user) {
        if (userRepository.existsById(user.getId())) {
            throw new UserAlreadyExistsException("User already exists with id: " + user.getId());
        }
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User saveUserWithStore(User user, Store store) {
        Store savedStore = storeRepository.save(store);

        user.setStore(savedStore);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(long id, User user) {
        User user1=userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User not found with id: " + id));
        user1.setFullName(user.getFullName());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setRole(user.getRole());
        return userRepository.save(user1);
    }
}
