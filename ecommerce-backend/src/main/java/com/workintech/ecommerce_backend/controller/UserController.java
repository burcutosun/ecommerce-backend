package com.workintech.ecommerce_backend.controller;

import com.workintech.ecommerce_backend.dto.SignupRequestDto;
import com.workintech.ecommerce_backend.dto.StoreDto;
import com.workintech.ecommerce_backend.dto.UserDto;
import com.workintech.ecommerce_backend.entity.Role;
import com.workintech.ecommerce_backend.entity.Store;
import com.workintech.ecommerce_backend.entity.User;
import com.workintech.ecommerce_backend.service.RoleService;
import com.workintech.ecommerce_backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final RoleService roleService;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody SignupRequestDto signupRequest) {
        UserDto userDTO = signupRequest.getUser();
        StoreDto storeDTO = signupRequest.getStore();

        User user = new User();
        user.setFullName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        Role role=roleService.getRoleById(userDTO.getRoleId());
        user.setRole(role);

        if ((userDTO.getRoleId()==2) && storeDTO != null) {
            Store store = new Store();
            store.setName(storeDTO.getName());
            store.setPhone(storeDTO.getPhone());
            store.setTaxNo(storeDTO.getTaxNo());
            store.setBankAccount(storeDTO.getBankAccount());

            User savedUser = userService.saveUserWithStore(user, store);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        } else {
            User savedUser = userService.saveUser(user);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
