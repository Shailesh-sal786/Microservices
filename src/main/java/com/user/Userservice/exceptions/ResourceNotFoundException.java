package com.user.Userservice.exceptions;

public class ResourceNotFoundException extends RuntimeException {

  //Extra properties you want to manage her

    public ResourceNotFoundException(){
        super("Resource not found on server !!");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }




}
