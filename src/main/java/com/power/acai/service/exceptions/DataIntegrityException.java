package com.power.acai.service.exceptions;

import javassist.NotFoundException;

public class DataIntegrityException extends NotFoundException {


    public DataIntegrityException(String msg) {
        super(msg);
    }

    public DataIntegrityException(String msg, Throwable cause) {
        super(msg, (Exception) cause);
    }
}