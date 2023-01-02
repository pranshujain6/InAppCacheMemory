package storage;

import java.util.NoSuchElementException;

// interface having method we need for every DS to store
public interface DataStore<Key, Value> {
	// add a key in for storage
    public void addKey(Key key, Value value) throws OutOfMemoryError;

    // remove a key for a storage
    void removeKey(Key key) throws NoSuchElementException;

    // return value of given key
    Value getValue(Key key) throws NoSuchElementException;
}
