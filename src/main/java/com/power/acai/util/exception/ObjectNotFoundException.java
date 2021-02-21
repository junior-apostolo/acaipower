package com.power.acai.util.exception;
import javassist.NotFoundException;

public class ObjectNotFoundException extends NotFoundException {


    public ObjectNotFoundException(String msg) {
        super(msg);
    }

    public ObjectNotFoundException(String msg, Throwable cause) {
        super(msg, (Exception) cause);
    }
}