package com.example.exceptionhandler;

public class WrongUrlException extends RuntimeException {
    public WrongUrlException(String message) {
        super(message);
    }
}
