package com.urise.webapp.exception;

/**
 * Created by karpenko on 14.08.2023.
 * Description:
 */
public class ExistStorageException extends StorageException {

    public ExistStorageException(String uuid) {
        super("Resume already exist", uuid);
    }

}
