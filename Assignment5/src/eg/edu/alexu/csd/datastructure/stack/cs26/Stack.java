package eg.edu.alexu.csd.datastructure.stack.cs26;


/**
 *  I WILL USE LINKEDLIST TO IMPLEMENT THE STACK
 */
public class Stack implements IStack {
    LikedList myStack = new LikedList();

    public Object pop()
    {
        Object element = myStack.getFirst(); //my head
        myStack.removeAtFirst();
        return element;
    }
    public Object peek()
    {
        return myStack.getFirst();
    }
    public void push(Object element)
    {
        myStack.addAtFirst(element);
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
