package com.msr.blog.system;

public class ObjectNotFoundException extends RuntimeException{

    public ObjectNotFoundException(String objectName,  Integer id)
    {
        super("Could not found "+ objectName + "with id :"+ id );
    }
}
