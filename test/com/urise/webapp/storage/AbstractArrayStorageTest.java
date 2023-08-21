package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Test;

import static org.junit.Assert.fail;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() {
        int size = storage.size() + 1;
        int storageLimit = AbstractArrayStorage.STORAGE_LIMIT;
        try {
            for (int i = size; i <= storageLimit; i++)
                storage.save(new Resume("Name" + i));
        } catch (StorageException ignored) {
            fail("Overflow unexpected!");
        }
        storage.save(new Resume("Overflow"));
    }

}