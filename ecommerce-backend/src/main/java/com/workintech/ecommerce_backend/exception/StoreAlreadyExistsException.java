package com.workintech.ecommerce_backend.exception;

public class StoreAlreadyExistsException extends RuntimeException{
    public StoreAlreadyExistsException(String message) {
        super(message);
    }
}
