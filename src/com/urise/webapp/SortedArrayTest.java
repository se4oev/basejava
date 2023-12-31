package com.urise.webapp;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.SortedArrayStorage;
import com.urise.webapp.storage.Storage;

/**
 * Created by karpenko on 11.08.2023.
 * Description:
 */
public class SortedArrayTest {

    static final Storage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        Resume r3 = new Resume("uuid3");
        Resume r1 = new Resume("uuid1");
        Resume r2 = new Resume("uuid2");

        ARRAY_STORAGE.save(r3);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r1);

        ARRAY_STORAGE.update(r2);
        ARRAY_STORAGE.update(r1);
        Resume r4 = new Resume("uuid4");
        ARRAY_STORAGE.update(r4);

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        printAll();
        ARRAY_STORAGE.delete(r1.getUuid());
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAllSorted()) {
            System.out.println(r);
        }
    }

}
