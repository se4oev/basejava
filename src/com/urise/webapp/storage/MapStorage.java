package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by karpenko on 15.08.2023.
 * Description:
 */
public class MapStorage extends AbstractStorage {

    private final Map<String, Resume> storage = new HashMap<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public void update(Resume r) {
        Resume resume = storage.get(r.getUuid());
        if (resume == null)
            throw new NotExistStorageException(r.getUuid());
        storage.put(r.getUuid(), r);
    }

    @Override
    public void save(Resume r) {
        Resume resume = storage.get(r.getUuid());
        if (resume != null)
            throw new ExistStorageException(r.getUuid());
        storage.put(r.getUuid(), r);
    }

    @Override
    public Resume get(String uuid) {
        Resume resume = storage.get(uuid);
        if (resume == null)
            throw new NotExistStorageException(uuid);
        return resume;
    }

    @Override
    public void delete(String uuid) {
        Resume removed = storage.remove(uuid);
        if (removed == null)
            throw new NotExistStorageException(uuid);
    }

    @Override
    public Resume[] getAll() {
        return storage.values().toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return storage.size();
    }

}
