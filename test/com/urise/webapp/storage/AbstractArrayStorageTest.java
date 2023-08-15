package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest {

    private final Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final Resume RESUME_1;
    private static final String UUID_2 = "uuid2";
    private static final Resume RESUME_2;
    private static final String UUID_3 = "uuid3";
    private static final Resume RESUME_3;
    private static final String UUID_4 = "uuid4";
    private static final Resume RESUME_4;

    static {
        RESUME_1 = new Resume(UUID_1);
        RESUME_2 = new Resume(UUID_2);
        RESUME_3 = new Resume(UUID_3);
        RESUME_4 = new Resume(UUID_4);
    }

    protected AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void update() {
        Resume newResume = new Resume(UUID_1);
        storage.update(newResume);

        Resume fromStorage = storage.get(UUID_1);
        assertSame(newResume, fromStorage);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(new Resume("dummy"));
    }

    @Test
    public void save() {
        storage.save(RESUME_4);
        assertSize(4);

        assertGet(RESUME_4);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExists() {
        storage.save(RESUME_1);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() {
        int size = storage.size() + 1;
        int storageLimit = AbstractArrayStorage.STORAGE_LIMIT;
        try {
            for (int i = size; i <= storageLimit; i++)
                storage.save(new Resume());
        } catch (StorageException ignored) {
            fail("Overflow unexpected!");
        }
        storage.save(new Resume());
    }

    @Test
    public void getAll() {
        Resume[] fromStorage = storage.getAll();
        assertEquals(3, fromStorage.length);
        assertEquals(RESUME_1, fromStorage[0]);
        assertEquals(RESUME_2, fromStorage[1]);
        assertEquals(RESUME_3, fromStorage[2]);
    }

    @Test
    public void size() {
        assertSize(3);
    }

    @Test
    public void get() {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test
    public void delete() {
        storage.delete(UUID_2);

        assertSize(2);
        assertThrows(NotExistStorageException.class, () -> storage.get(UUID_2));
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete("dummy");
    }

    private void assertGet(Resume r) {
        assertEquals(r, storage.get(r.getUuid()));
    }

    private void assertSize(int expected) {
        assertEquals(expected, storage.size());
    }

}