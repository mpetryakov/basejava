/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    final int length = 10000;

    Resume[] storage = new Resume[length];
    int size = 0;

    void clear() {
        for (int i=0; i<size; i++){
            storage[i] = null;
        }
        size=0;
    }

    void save(Resume r) {
        if(size < length) {
            boolean uuidAlreadyExist = false;
            for (int i = 0; i < size; i++) {
                if (storage[i].uuid.equalsIgnoreCase(r.uuid)) {
                    uuidAlreadyExist = true;
                    System.err.println(String.format("Resume %s already exist in storage", r.uuid));
                    break;
                }
            }
            if(!uuidAlreadyExist) {
                storage[size] = r;
                size++;
            }
        }
    }

    Resume get(String uuid) {
        Resume r = null;
        for (int i=0; i<size; i++){
            if(storage[i].uuid.equalsIgnoreCase(uuid)){
                r = storage[i];
                break;
            }
        }
        return r;
    }

    void delete(String uuid) {
        for (int i=0; i<size; i++) {
            if (storage[i].uuid.equalsIgnoreCase(uuid)) {
                for (int j = i; j < size-1; j++) {
                    storage[j] = storage[j + 1];
                }
                storage[size-1]=null;
                size--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return storage;
    }

    int size() {
        return size;
    }
}
