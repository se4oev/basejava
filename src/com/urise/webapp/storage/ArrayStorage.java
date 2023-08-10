package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
            System.out.println("Error occurred while trying to update Resume with uuid: " +
                    r.getUuid() + ", not presented");
            return;
        }
        storage[index] = r;
    }

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

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Error occurred while trying to get Resume with uuid: " +
                    uuid + ", not presented");
            return null;
        }

        return storage[index];
    }

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

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

}
