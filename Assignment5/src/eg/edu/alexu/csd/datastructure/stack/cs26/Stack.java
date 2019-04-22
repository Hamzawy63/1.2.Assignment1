package eg.edu.alexu.csd.datastructure.stack.cs26;

import java.util.LinkedList;

/**
 *  I WILL USE LINKEDLIST TO IMPLEMENT THE STACK
 */

public class Stack implements IStack {
    LinkedList myStack = new LinkedList();
    int size = -1;

    public Object pop()
    {
        Object element = myStack.getFirst(); //my head
        myStack.removeFirst();
        return element;
    }
    public Object peek()
    {
        return myStack.getFirst();
    }
    public void push(Object element)
    {
        myStack.addFirst(element);
    }
     public boolean isEmpty()
     {
         return myStack.isEmpty();
     }
     public int size()
     {
         return myStack.size();
     }

}
