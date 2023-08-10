package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Created by karpenko on 10.08.2023.
 * Description:
 */
public abstract class AbstractArrayStorage implements Storage {

    protected static final int STORAGE_LIMIT = 100000;

    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    @Override
    public int size() {
        return size;
    }

    protected abstract int getIndex(String uuid);

}
