package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractArrayStorageTest {

    protected final Storage storage;

    protected static final String UUID_1 = "uuid1";
    protected static final String UUID_2 = "uuid2";
    protected static final String UUID_3 = "uuid3";

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void update() {
        Resume newResume = new Resume(UUID_1);
        storage.update(newResume);

        Resume fromStorage = storage.get(UUID_1);
        Assert.assertEquals(newResume, fromStorage);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(new Resume("dummy"));
    }

    @Test
    public void save() {
        Resume newResume = new Resume("dummy");
        storage.save(newResume);

        Resume fromStorage = storage.get("dummy");
        Assert.assertEquals(newResume, fromStorage);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExists() {
        storage.save(new Resume(UUID_1));
    }

    @Test(expected = StorageException.class)
    public void saveOverFlow() {
        int count = 10000 - storage.size();
        for (int i = 0; i < count; i++) {
            try {
                storage.save(new Resume());
            } catch (StorageException ignored) {
                Assert.fail("Overflow unexpected!");
            }
        }
        storage.save(new Resume());
    }

    @Test
    public void getAll() {
        Resume[] expected = new Resume[]{
                new Resume(UUID_1),
                new Resume(UUID_2),
                new Resume(UUID_3)
        };

        Resume[] fromStorage = storage.getAll();

        Assert.assertArrayEquals(expected, fromStorage);
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void get() {
        Resume expected = new Resume(UUID_1);
        Resume fromStorage = storage.get(UUID_1);

        Assert.assertNotNull(fromStorage);
        Assert.assertEquals(expected, fromStorage);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test
    public void delete() {
        storage.delete(UUID_2);

        Assert.assertEquals(2, storage.size());
        Assert.assertThrows(NotExistStorageException.class, () -> storage.get(UUID_2));
    }

}