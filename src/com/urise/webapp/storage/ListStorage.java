package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by karpenko on 15.08.2023.
 * Description:
 */
public class ListStorage extends AbstractStorage<Integer> {

    private final List<Resume> storage = new ArrayList<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    protected void doUpdate(Resume r, Integer index) {
        storage.set(index, r);
    }

    @Override
    protected void doSave(Resume r, Integer index) {
        storage.add(r);
    }

    @Override
    protected Resume doGet(Integer index) {
        return storage.get(index);
    }

    @Override
    protected void doDelete(Integer index) {
        storage.remove(index.intValue());
    }

    @Override
    protected List<Resume> doCopyAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public int size() {
        return storage.size();
    }

    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid))
                return i;
        }
        return null;
    }

    @Override
    protected boolean exist(Integer searchKey) {
        return searchKey != null;
    }

}
