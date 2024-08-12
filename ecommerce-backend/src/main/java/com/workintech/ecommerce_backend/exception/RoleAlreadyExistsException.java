package com.workintech.ecommerce_backend.exception;

public class RoleAlreadyExistsException extends RuntimeException{
    public RoleAlreadyExistsException(String message) {
        super(message);
    }
}
