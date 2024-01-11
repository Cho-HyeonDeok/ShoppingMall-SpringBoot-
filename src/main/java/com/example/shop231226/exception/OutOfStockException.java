package com.example.shop231226.exception;

public class OutOfStockException extends RuntimeException{

    public OutOfStockException(String message) {
        super(message);
    }
}
