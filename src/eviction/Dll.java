package eviction;


public class Dll<E> {

	DllNode<E> dummyHead;
	DllNode<E> dummyTail;

    public Dll() {
        // We can instantiate these by null, since we are never gonna use val for these dummyNodes
        dummyHead = new DllNode<>(null);
        dummyTail = new DllNode<>(null);

        // Also Initially there are no items
        // so just join dummyHead and Tail, we can add items in between them easily.
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    // remove node from list
    public void detachNode(DllNode<E> node) {
        // Just Simply modifying the pointers.
        if (node != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    // add node at last of list
    public void addNodeAtLast(DllNode<E> node) {
        DllNode tailPrev = dummyTail.prev;
        tailPrev.next = node;
        node.next = dummyTail;
        dummyTail.prev = node;
        node.prev = tailPrev;
    }

   // add element at last of list
    public DllNode<E> addElementAtLast(E element) {
        if (element == null) {
            return null;
        }
        DllNode<E> newNode = new DllNode<>(element);
        addNodeAtLast(newNode);
        return newNode;
    }

    // check is items are present
    public boolean isItemPresent() {
        return dummyHead.next != dummyTail;
    }

    // returns first node if present
    public DllNode getFirstNode() {
    	DllNode item = null;
        if (!isItemPresent()) {
            return null;
        }
        return dummyHead.next;
    }

    // returns last node
    public DllNode getLastNode(){
    	DllNode item = null;
        if (!isItemPresent()) {
            return null;
        }
        return dummyTail.prev;
    }
}
