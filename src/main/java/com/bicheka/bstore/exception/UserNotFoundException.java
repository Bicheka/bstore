package com.bicheka.bstore.exception;

public class UserNotFoundException extends RuntimeException { 

    public UserNotFoundException(Long id) {
        super("The student id '" + id + "' does not exist in our records");
    }
    
}