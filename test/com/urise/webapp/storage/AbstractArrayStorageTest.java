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
        int size = getStorage().size() + 1;
        int storageLimit = AbstractArrayStorage.STORAGE_LIMIT;
        try {
            for (int i = size; i <= storageLimit; i++)
                getStorage().save(new Resume());
        } catch (StorageException ignored) {
            fail("Overflow unexpected!");
        }
        getStorage().save(new Resume());
    }

}