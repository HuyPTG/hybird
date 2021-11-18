package com.training.hyrid.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message){
        super(message);
    }
}
