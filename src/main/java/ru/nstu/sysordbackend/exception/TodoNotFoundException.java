package ru.nstu.sysordbackend.exception;

public class TodoNotFoundException extends Exception{
    public TodoNotFoundException(String message) {
        super(message);
    }
}
