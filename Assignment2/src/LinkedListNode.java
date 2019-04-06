public class LinkedListNode {
    int value;
    LinkedListNode next =null;

    public int getValue()
    {
        return value;
    }
    public LinkedListNode getNext()
    {
        return next;
    }
    LinkedListNode(int a)
    {
        value = a;
        next = null;
    }
    LinkedListNode()
    {
        value = 0;
        next = null;
    }

}
