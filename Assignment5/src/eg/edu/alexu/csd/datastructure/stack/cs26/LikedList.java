package eg.edu.alexu.csd.datastructure.stack.cs26;

public class LikedList {
    public class Node
    {
        Object value;
        Node next =  null;
        Node(Object value )
        {
            this.value = value;
            next = null;
        }

    }
    private Node head;
    int size = 0;
    public void addAtFirst(Object value )
    {
        Node element = new Node(value);
        element.next = head;
        head = element;
        size++;
    }
    public boolean isEmpty()
    {
        return head == null;
    }
    public int  size()
    {
        return size;
    }
    public void removeAtFirst()
    {
        if(head == null)
        {
            System.out.println("Invalid operation null exception");
        }
        head = head.next;
        size--;
    }
    public Object getFirst()
    {
        return head == null ? null :head.value;
    }

}
