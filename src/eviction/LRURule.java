package eviction;


import java.util.HashMap;
import java.util.Map;

// LRU based eviction rule
// least recently used one
public class LRURule<Key> implements Rules<Key> {

    private Dll<Key> dll;
    private Map<Key, DllNode<Key>> map;

    public LRURule() {
        this.dll = new Dll<>();
        this.map = new HashMap<>();
    }

    public void keyUsed(Key key) {
        if (map.containsKey(key)) {
        	// remove and add key at starting
            dll.detachNode(map.get(key));
            dll.addNodeAtLast(map.get(key));
        } else {
        	// add key at last if not exist
            DllNode<Key> newNode = dll.addElementAtLast(key);
            map.put(key, newNode);
        }
    }

    @Override
    public Key removeKey() {
    	// remove first key
        DllNode<Key> first = dll.getFirstNode();
        if(first == null) {
            return null;
        }
        dll.detachNode(first);
        return first.element;
    }
}
