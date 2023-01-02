package eviction;

public class DllNode<E> {
	DllNode<E> next;
	DllNode<E> prev;
    E element;

    public DllNode(E element) {
        this.element = element;
        this.next = null;
        this.prev = null;
    }
}
