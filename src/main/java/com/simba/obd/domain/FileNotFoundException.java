package com.simba.obd.domain;

/**
 * Created by podisto on 26/08/2021.
 */
public class FileNotFoundException extends RuntimeException {
    public FileNotFoundException(String message) {
        super(message);
    }

    public FileNotFoundException(String message, Throwable e) {
        super(message, e);
    }
}
