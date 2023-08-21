package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Collections;
import java.util.List;

/**
 * Created by karpenko on 21.08.2023.
 * Description:
 */
public class MapUuidStorage extends AbstractStorage {

    @Override
    protected Object getSearchKey(String uuid) {
        return null;
    }

    @Override
    protected boolean exist(Object searchKey) {
        return false;
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {

    }

    @Override
    protected void doSave(Resume r, Object searchKey) {

    }

    @Override
    protected void doDelete(Object searchKey) {

    }

    @Override
    protected Resume doGet(Object searchKey) {
        return null;
    }

    @Override
    protected List<Resume> doCopyAll() {
        return Collections.emptyList();
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

}
