package eg.edu.alexu.csd.datastructure.queue.cs26_cs61_cs17;

public class myLinkedList {

    private class Node {
        Object value;
        Node next;

        Node(Object val) {
            value = val;
            next = null;
        }

    }

    Node head = null;
    int size = 0;

    public Object removeAtFirst() throws IllegalStateException {
        if (head == null) {
            throw new IllegalStateException("LINKED LIST IS EMPTY ");
        }
        Node tmp = head;
        head = head.next;
        size--;
        return tmp.value;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void add(Object o) {
        Node newNode = new Node(o);
        Node ptr = head;
        size++;
        if(ptr == null)
        {
            head = newNode;
            return;
        }
        while(ptr.next!= null)
        {
            ptr = ptr. next;
        }
        ptr.next = newNode;
    }

    public void print() {
        Node ptr = head;
        while (ptr != null) {
            System.out.print(ptr.value + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }
    public Object getFirst()
    {
        if(head ==null)
            return null;
        else
            return head.value;
    }


}
