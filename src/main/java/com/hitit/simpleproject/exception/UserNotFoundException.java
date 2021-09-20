package com.hitit.simpleproject.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(long id){
        super("Invalid user Id:" + id);
    }
}
