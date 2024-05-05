package com.damageddream.products.exception;

public class RequiredFieldIsNullException extends RuntimeException{
    public RequiredFieldIsNullException(String message) {
        super(message);
    }
}
