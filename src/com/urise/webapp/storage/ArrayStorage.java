package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume r) {
        if (getIndex(r.getUuid()) > 0) {
            System.out.println("Error occurred while trying to save Resume with uuid: " +
                    r.getUuid() + ", already present");
            return;
        }
        if (size >= STORAGE_LIMIT) {
            System.out.println("Error occurred while trying to save Resume with uuid: " +
                    r.getUuid() + ", storage is full");
            return;
        }
        storage[size] = r;
        size++;
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Error occurred while trying to delete Resume with uuid: " +
                    uuid + ", not presented");
            return;
        }
        size--;
        storage[index] = storage[size];
        storage[size] = null;
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

}
