package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by karpenko on 15.08.2023.
 * Description:
 */
public abstract class AbstractStorage<K> implements Storage {

    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    @Override
    public void update(Resume r) {
        LOG.info("Update " + r);
        K searchKey = getExistedSearchKey(r.getUuid());
        doUpdate(r, searchKey);
    }

    @Override
    public void save(Resume r) {
        LOG.info("Save " + r);
        K searchKey = getNotExistedSearchKey(r.getUuid());
        doSave(r, searchKey);
    }

    @Override
    public void delete(String uuid) {
        LOG.info("Delete " + uuid);
        K searchKey = getExistedSearchKey(uuid);
        doDelete(searchKey);
    }

    @Override
    public Resume get(String uuid) {
        LOG.info("Get " + uuid);
        K searchKey = getExistedSearchKey(uuid);
        return doGet(searchKey);
    }

    private K getExistedSearchKey(String uuid) {
        K searchKey = getSearchKey(uuid);
        if (!exist(searchKey)) {
            LOG.warning("Resume " + uuid + " not exist");
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private K getNotExistedSearchKey(String uuid) {
        K searchKey = getSearchKey(uuid);
        if (exist(searchKey)) {
            LOG.warning("Resume " + uuid + " already exist");
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    @Override
    public List<Resume> getAllSorted() {
        LOG.info("Get all sorted");
        List<Resume> list = doCopyAll();
        Collections.sort(list);
        return list;
    }

    protected abstract K getSearchKey(String uuid);

    protected abstract boolean exist(K searchKey);

    protected abstract void doUpdate(Resume r, K searchKey);

    protected abstract void doSave(Resume r, K searchKey);

    protected abstract void doDelete(K searchKey);

    protected abstract Resume doGet(K searchKey);

    protected abstract List<Resume> doCopyAll();

}

