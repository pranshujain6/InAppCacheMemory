import java.util.NoSuchElementException;

import eviction.Rules;
import storage.DataStore;

public class Cache<Key, Value> {
    private final Rules<Key> evictionRule;
    private final DataStore<Key, Value> storage;

    public Cache(Rules<Key> evictionRule, DataStore<Key, Value> storage) {
        this.evictionRule = evictionRule;
        this.storage = storage;
    }

    public void put(Key key, Value value) {
        try {
            this.storage.addKey(key, value);
            this.evictionRule.keyUsed(key);
        } catch (OutOfMemoryError exception) {
            System.out.println("Got storage full evicting ele");
            Key keyToRemove = evictionRule.removeKey();
            if (keyToRemove == null) {
                throw new RuntimeException("No key to evict");
            }
            this.storage.removeKey(keyToRemove);
            System.out.println("Evicting key" + keyToRemove);
            put(key, value);
        }
    }

    public Value get(Key key) {
        try {
            Value value = this.storage.getValue(key);
            this.evictionRule.keyUsed(key);
            return value;
        } catch (NoSuchElementException exception) {
            System.out.println("Tried to access non-existing key.");
            return null;
        }
    }


}
