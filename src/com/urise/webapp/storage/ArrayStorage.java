package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private int size;
    Resume[] storage = new Resume[10000];

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        Resume resume = findByUuid(r.getUuid());
        if (resume == null) {
            System.out.println("Error occurred while trying to update Resume with uuid: " +
                    r.getUuid() + ", not presented");
            return;
        }
        resume.setUuid(r.getUuid());
    }

    public void save(Resume r) {
        Resume resume = findByUuid(r.getUuid());
        if (resume != null) {
            System.out.println("Error occurred while trying to save Resume with uuid: " +
                    r.getUuid() + ", already present");
            return;
        }
        if (size >= storage.length) {
            System.out.println("Error occurred while trying to save Resume with uuid: " +
                    r.getUuid() + ", storage is full");
            return;
        }
        storage[size] = r;
        size++;
    }

    public Resume get(String uuid) {
        Resume resume = findByUuid(uuid);
        if (resume == null) {
            System.out.println("Error occurred while trying to get Resume with uuid: " +
                    uuid + ", not presented");
        }
        return resume;
    }

    private Resume findByUuid(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        Resume resume = findByUuid(uuid);
        if (resume == null) {
            System.out.println("Error occurred while trying to delete Resume with uuid: " +
                    uuid + ", not presented");
            return;
        }
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                size--;
                storage[i] = storage[size];
                storage[size] = null;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

}
