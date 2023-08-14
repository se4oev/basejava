package com.urise.webapp.exception;

/**
 * Created by karpenko on 14.08.2023.
 * Description:
 */
public class NotExistStorageException extends StorageException {

    public NotExistStorageException(String uuid) {
        super("Resume " + uuid + " not exist", uuid);
    }

}
