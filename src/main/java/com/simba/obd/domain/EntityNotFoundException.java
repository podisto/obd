package com.simba.obd.domain;

/**
 * Created by podisto on 27/08/2021.
 */
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
