package com.example.Lab1_OO.Exception;

public class NotSavedInDatabaseException extends RuntimeException {
    public NotSavedInDatabaseException(String message) {
        super(message);
    }
}
