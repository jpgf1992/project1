package com.jota.course.application.services.Exceptions;

public class ResourceNotFoundException extends RuntimeException {


    public ResourceNotFoundException(Object id){
        super("Resouce not found . ID " + id);
    }


}
