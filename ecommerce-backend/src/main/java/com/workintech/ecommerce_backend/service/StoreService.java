package com.workintech.ecommerce_backend.service;

import com.workintech.ecommerce_backend.entity.Store;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StoreService {
    List<Store> getAllStores();
    Store getStoreById(long id);
    Store saveStore(Store store);
    void deleteStore(long id);
    Store updateStore(long id, Store store);
}
