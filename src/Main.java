
import storage.HashMapDataStore;
import eviction.FifoRule;
import eviction.LifoRule;
import eviction.LRURule;

public class Main {

    public static void main(String[] args) {
	
    Cache<Integer,Integer> lru = new Cache<Integer, Integer>(new LRURule<Integer>(), new HashMapDataStore<Integer, Integer>(5));
    lru.put(1, 1);
    lru.put(2,2);
    lru.put(3,3);
    lru.put(4, 4);
    lru.put(5, 5);
    System.out.println(lru.get(1));
    lru.put(6,6);
    
    System.out.println("FIFO");
    
    Cache<Integer, Integer> fifo = new Cache<Integer, Integer>(new FifoRule<Integer>(), new HashMapDataStore<Integer,Integer>(5));
    fifo.put(1, 1);
    fifo.put(2,2);
    fifo.put(3,3);
    fifo.put(4, 4);
    fifo.put(5, 5);
    System.out.println(fifo.get(2));
    fifo.put(6,6);
    fifo.put(7, 7);
    
    System.out.println("LIFO");
    Cache<Integer, Integer> lifo = new Cache<Integer, Integer>(new LifoRule<Integer>(), new HashMapDataStore<Integer, Integer>(5));
    lifo.put(1, 1);
    lifo.put(2, 2);
    lifo.put(3, 3);
    lifo.put(4, 4);
    lifo.put(5, 5);
    System.out.println(lifo.get(2));
    lifo.put(6, 6);
    lifo.put(7,7);
    }
}
