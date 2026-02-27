package com.example.gymjavaproject.exception;

public class notFoundExceptionPer extends RuntimeException {
    public notFoundExceptionPer(String message) {
        super(message);
    }

    public notFoundExceptionPer(String message, Throwable cause) {
        super(message, cause);
    }
}
