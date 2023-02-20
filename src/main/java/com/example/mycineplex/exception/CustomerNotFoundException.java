package com.example.mycineplex.exception;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String message, int cust_id) {
        super(message);
    }
}
