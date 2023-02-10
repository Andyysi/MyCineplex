package com.example.mycineplex.exception;

public class UnsupportedLoginNameException extends RuntimeException{
    public UnsupportedLoginNameException(String message) {
        super(message);
    }
}
