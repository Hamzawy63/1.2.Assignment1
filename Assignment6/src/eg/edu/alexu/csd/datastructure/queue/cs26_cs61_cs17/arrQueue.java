package eg.edu.alexu.csd.datastructure.queue.cs26_cs61_cs17;

public class arrQueue implements IArrayBased, IQueue {
    private Object arr[];
    private int size = 0;
    private int front = -1;
    private int end = -1;

    /*
        we will implement the interface using circular queue approach commment
     */
    arrQueue(int Capacity) { arr = new Object[Capacity];}

    public void enqueue(Object item) throws IllegalStateException {
        if ((front == -1 && end == arr.length - 1) || (front == end && front != -1))
            throw new IllegalStateException("Queue is full");

        end = (end + 1) % arr.length;
        arr[end] = item;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object dequeue() throws IllegalStateException {
        if (isEmpty())
            throw new IllegalStateException("Queue is Empty");

        front = (front+1)%arr.length;
        size--;
        return arr[front];
    }

    public int size()
    {
        return size;
    }


}
