package com.oms.exception.handler;

public class WrongUrlException extends RuntimeException {
    public WrongUrlException(String message) {
        super(message);
    }
}
