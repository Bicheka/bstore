package com.bicheka.bstore.exception;

public class SellerNotFoundException extends RuntimeException{
    public SellerNotFoundException(Long id) {
        super("The seller id '" + id + "' does not exist in our records");
    }
}
