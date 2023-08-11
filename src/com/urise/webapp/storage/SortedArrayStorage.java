package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Created by karpenko on 10.08.2023.
 * Description:
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume r) {
        if (getIndex(r.getUuid()) > 0) {
            System.out.println("Error occurred while trying to save Resume with uuid: " +
                    r.getUuid() + ", already present");
            return;
        }
        if (size == 0) {
            storage[size] = r;
            size++;
            return;
        }

        for (int i = 0; i <= size; i++) {
            //дошли до конца
            if (i == size) {
                storage[i] = r;
                size++;
                return;
            }
            if (storage[i].compareTo(r) < 0)
                continue;
            System.arraycopy(storage, i, storage, i + 1, size - i);
            storage[i] = r;
            size++;
            break;
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Error occurred while trying to delete Resume with uuid: " +
                    uuid + ", not presented");
            return;
        }
        System.arraycopy(storage, index + 1, storage, index, size - index);
        size--;
        storage[size] = null;
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

}
