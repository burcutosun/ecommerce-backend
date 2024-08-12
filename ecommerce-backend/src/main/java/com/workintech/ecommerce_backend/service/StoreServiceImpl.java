package com.workintech.ecommerce_backend.service;

import com.workintech.ecommerce_backend.entity.Store;
import com.workintech.ecommerce_backend.exception.StoreAlreadyExistsException;
import com.workintech.ecommerce_backend.exception.StoreNotFoundException;
import com.workintech.ecommerce_backend.exception.UserNotFoundException;
import com.workintech.ecommerce_backend.repo.StoreRepository;
import com.workintech.ecommerce_backend.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StoreServiceImpl implements StoreService{

    private final UserRepository userRepository;

    private final StoreRepository storeRepository;

    @Override
    public List<Store> getAllStores() {
        List<Store> stores=storeRepository.findAll();
        if(stores.isEmpty()){
            throw new StoreNotFoundException("No stores found");
        }
        return stores;
    }

    @Override
    public Store getStoreById(long id) {
        return storeRepository.findById(id).orElseThrow(()-> new StoreNotFoundException("Store not found with id: " + id));
    }

    @Override
    public Store saveStore(Store store) {
        if (storeRepository.existsById(store.getId())) {
            throw new StoreAlreadyExistsException("Store already exists with id: " + store.getId());
        }
        return storeRepository.save(store);
    }

    @Override
    public void deleteStore(long id) {
        if (!storeRepository.existsById(id)) {
            throw new StoreNotFoundException("Store not found with id: " + id);
        }
        userRepository.updateStoreIdToNull(id);
        storeRepository.deleteById(id);
    }

    @Override
    public Store updateStore(long id, Store store) {
        Store store1=storeRepository.findById(id).orElseThrow(()->new StoreNotFoundException("Store not found with id: " + id));
        store1.setName(store.getName());
        store1.setPhone(store.getPhone());
        store1.setTaxNo(store.getTaxNo());
        store1.setBankAccount(store.getBankAccount());
        return storeRepository.save(store1);
    }
}
