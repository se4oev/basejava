package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

/**
 * Created by karpenko on 10.08.2023.
 * Description:
 */
public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {

    protected static final int STORAGE_LIMIT = 10000;

    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected void doUpdate(Resume r, Integer index) {
        storage[index] = r;
    }

    @Override
    protected void doSave(Resume r, Integer index) {
        if (size >= STORAGE_LIMIT)
            throw new StorageException("Storage overflow", r.getUuid());

        insertElement(r, index);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    protected Resume doGet(Integer index) {
        return storage[index];
    }

    @Override
    protected void doDelete(Integer index) {
        fillDeletedElement(index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected boolean exist(Integer index) {
        return index >= 0;
    }

    @Override
    protected List<Resume> doCopyAll() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, size));
    }

    protected abstract Integer getSearchKey(String uuid);

    protected abstract void insertElement(Resume r, int index);

    protected abstract void fillDeletedElement(int index);

}
