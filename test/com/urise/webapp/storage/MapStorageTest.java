package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MapStorageTest extends AbstractStorageTest {

    public MapStorageTest() {
        super(new MapStorage());
    }

    @Override
    @Test
    public void getAll() {
        //TODO: ?
        Resume[] fromStorage = storage.getAll();
        assertEquals(3, fromStorage.length);
        assertNotNull(storage.get("uuid1"));
        assertNotNull(storage.get("uuid2"));
        assertNotNull(storage.get("uuid3"));
    }

}