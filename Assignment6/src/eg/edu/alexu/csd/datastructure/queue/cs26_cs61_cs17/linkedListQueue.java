package eg.edu.alexu.csd.datastructure.queue.cs26_cs61_cs17;


public class linkedListQueue implements IQueue,ILinkedBased {
    myLinkedList ll = new myLinkedList();

    public void enqueue(Object item) {
        ll.add(item);
    }

    public Object dequeue () throws IllegalStateException {
        Object tmp = ll.getFirst();
        if(tmp == null)
            throw new IllegalStateException("Queue is empty");
        ll.removeAtFirst();
        return tmp;
    }

    public boolean isEmpty() {
        return ll.isEmpty();
    }

    public int size() {
        return ll.size();
    }

}
