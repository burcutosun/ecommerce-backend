package com.workintech.ecommerce_backend.exception;

public class StoreNotFoundException extends RuntimeException{
    public StoreNotFoundException(String message) {
        super(message);
    }
}
