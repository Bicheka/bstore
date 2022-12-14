package com.bicheka.bstore.exception;

public class CostumerNotFoundException extends RuntimeException{
    public CostumerNotFoundException(Long id) {
        super("The costumer id '" + id + "' does not exist in our records");
    }
}
