package com.taxiservice.exceptions;

public class DriverNotFound extends RuntimeException {

    public DriverNotFound(String msg){
        super(msg);
    }
}
