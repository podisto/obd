package com.simba.obd;

/**
 * Created by podisto on 26/08/2021.
 */
public class FileStorageException extends RuntimeException {
    public FileStorageException(String message, Exception e) {
        super(message, e);
    }

    public FileStorageException(String message) {
        super(message);
    }
}
