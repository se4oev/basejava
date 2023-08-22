package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

/**
 * Created by karpenko on 21.08.2023.
 * Description:
 */
public class MapUuidStorage extends AbstractStorage<String> {

    private final Map<String, Resume> storage = new HashMap<>();

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean exist(String searchKey) {
        return storage.containsKey(searchKey);
    }

    @Override
    protected void doUpdate(Resume r, String searchKey) {
        storage.put(searchKey, r);
    }

    @Override
    protected void doSave(Resume r, String searchKey) {
        storage.put(searchKey, r);
    }

    @Override
    protected void doDelete(String searchKey) {
        storage.remove(searchKey);
    }

    @Override
    protected Resume doGet(String searchKey) {
        return storage.get(searchKey);
    }

    @Override
    protected List<Resume> doCopyAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public int size() {
        return storage.size();
    }

}
