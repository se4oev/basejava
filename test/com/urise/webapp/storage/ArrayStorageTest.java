package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Test;

public class ArrayStorageTest extends AbstractArrayStorageTest {

    private static final ArrayStorage storage = new ArrayStorage();

    public ArrayStorageTest() {
        super(storage);
    }

    @Test
    public void getIndex() {
        int index1 = storage.getIndex(UUID_1);
        Assert.assertEquals(0, index1);

        int index2 = storage.getIndex(UUID_2);
        Assert.assertEquals(1, index2);

        int index3 = storage.getIndex(UUID_3);
        Assert.assertEquals(2, index3);
    }

    @Test
    public void insertElement() {
        Resume resume = new Resume("dummy");
        storage.insertElement(resume, 3);

        Assert.assertEquals(3, storage.size());
        storage.size++;

        Resume fromStorage = storage.get("dummy");
        Assert.assertNotNull(fromStorage);
    }

    @Test
    public void fillDeletedElement() {
        storage.fillDeletedElement(1);
        int index = storage.getIndex(UUID_3);
        Assert.assertEquals(1, index);
    }

}