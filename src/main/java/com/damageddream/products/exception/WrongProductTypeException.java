package com.damageddream.products.exception;

public class WrongProductTypeException extends RuntimeException{
    public WrongProductTypeException(String message) {
        super(message);
    }
}
