package eviction;

import java.util.HashMap;
import java.util.Map;

public class LifoRule<Key> implements Rules<Key> {
	
	 private Dll<Key> dll;
	 private Map<Key, DllNode<Key>> map;

	public LifoRule() {
		 this.dll = new Dll<>();
	     this.map = new HashMap<>();
	}


	@Override
	public void keyUsed(Key key) {
		if (!map.containsKey(key)){
            DllNode<Key> newNode = dll.addElementAtLast(key);
            map.put(key, newNode);
		}
	}

	@Override
	public Key removeKey() {
		DllNode<Key> first = dll.getLastNode();
        if(first == null) {
            return null;
        }
        dll.detachNode(first);
        return first.element;
	}
}
