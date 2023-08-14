package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Created by karpenko on 10.08.2023.
 * Description:
 */
public abstract class AbstractArrayStorage implements Storage {

    protected static final int STORAGE_LIMIT = 100000;

    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void update(Resume r) {
        int index = getIndex(r.getUuid());

        if (index < 0)
            throw new NotExistStorageException(r.getUuid());

        storage[index] = r;
    }

    @Override
    public void save(Resume r) {
        int index = getIndex(r.getUuid());

        if (index > 0)
            throw new ExistStorageException(r.getUuid());

        if (size >= STORAGE_LIMIT)
            throw new StorageException("Storage overflow", r.getUuid());

        insertElement(r, index);
        size++;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Resume get(String uuid) {
        int index = getIndex(uuid);

        if (index < 0)
            throw new NotExistStorageException(uuid);

        return storage[index];
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);

        if (index < 0)
            throw new NotExistStorageException(uuid);

        fillDeletedElement(index);
        storage[size - 1] = null;
        size--;
    }

    protected abstract int getIndex(String uuid);

    protected abstract void insertElement(Resume r, int index);

    protected abstract void fillDeletedElement(int index);

}
