/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null)
                break;
            storage[i] = null;
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        for (Resume resume : storage) {
            if (resume == null)
                return null;
            if (resume.uuid.equals(uuid))
                return resume;
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null)
                break;
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                //после удаления сдвигаем оставшиеся элементы влево на один индекс
                for (int j = i; j < storage.length - 1; j++) {
                    if (storage[j + 1] == null)
                        break;
                    storage[j] = storage[j + 1];
                    storage[j + 1] = null;
                }
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int size = size();
        Resume[] resumes = new Resume[size];
        for (int i = 0; i < resumes.length; i++)
            resumes[i] = storage[i];
        return resumes;
    }

    int size() {
        int size = 0;
        for (Resume resume : storage) {
            if (resume == null)
                break;
            size++;
        }
        return size;
    }
}
