package com.forthreal;

public class AppException extends Exception {
    public AppException(String message)
    {
        super("AppException occurred: " + message);
    }
}
