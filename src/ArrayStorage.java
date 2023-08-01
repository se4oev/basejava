/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private int pointer = 0;
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < pointer; i++) {
            storage[i] = null;
        }
        pointer = 0;
    }

    void save(Resume r) {
        if (pointer >= storage.length) {
            return;
        }
        storage[pointer] = r;
        pointer++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < pointer; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < pointer; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                //после удаления сдвигаем оставшиеся элементы влево на один индекс
                for (int j = i; j < pointer - 1; j++) {
                    if (storage[j + 1] == null) {
                        break;
                    }
                    storage[j] = storage[j + 1];
                    storage[j + 1] = null;
                }
                pointer--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = new Resume[pointer];
        for (int i = 0; i < pointer; i++) {
            resumes[i] = storage[i];
        }
        return resumes;
    }

    int size() {
        return pointer;
    }

}
