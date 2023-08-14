package com.urise.webapp.exception;

/**
 * Created by karpenko on 14.08.2023.
 * Description:
 */
public class StorageException extends RuntimeException {

    private final String uuid;

    public StorageException(String uuid, String message) {
        super(message);
        this.uuid = uuid;
    }

}
