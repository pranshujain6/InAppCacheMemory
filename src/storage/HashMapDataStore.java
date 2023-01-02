package storage;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

// use hashmap class and implements DataStore
public class HashMapDataStore<Key, Value> implements DataStore<Key, Value> {

    Map<Key, Value> map;
    private final Integer capacity;

    public HashMapDataStore(Integer capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    // to override addKey method
    public void addKey(Key key, Value value) throws OutOfMemoryError {
        if (isStorageFull()) throw new OutOfMemoryError("Size full not adding ele");
        // add key capacity allows
        map.put(key, value);
    }

    // to override removeKey method
    public void removeKey(Key key) throws NoSuchElementException {
        if (!map.containsKey(key)) throw new NoSuchElementException(key + "doesnt exist in map");
        // key exist remove
        map.remove(key);
    }

    // return value
    public Value getValue(Key key) throws NoSuchElementException {
        if (!map.containsKey(key)) throw new NoSuchElementException(key + "doesn't exist in map.");
        // key exist return value
        return map.get(key);
    }

    // check if size is full which is capacity==map
    private boolean isStorageFull() {
        return map.size() == capacity;
    }
}
