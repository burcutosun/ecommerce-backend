package com.workintech.ecommerce_backend.controller;

import com.workintech.ecommerce_backend.entity.Store;
import com.workintech.ecommerce_backend.service.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")
@AllArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @GetMapping
    public ResponseEntity<List<Store>> getAllStores() {
        List<Store> stores = storeService.getAllStores();
        return new ResponseEntity<>(stores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Store> getStoreById(@PathVariable("id") long id) {
        Store store = storeService.getStoreById(id);
        return new ResponseEntity<>(store, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Store> createStore(@RequestBody Store store) {
        Store createdStore = storeService.saveStore(store);
        return new ResponseEntity<>(createdStore, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Store> updateStore(@PathVariable("id") long id, @RequestBody Store store) {
        Store updatedStore = storeService.updateStore(id, store);
        return new ResponseEntity<>(updatedStore, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStore(@PathVariable("id") long id) {
        storeService.deleteStore(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
