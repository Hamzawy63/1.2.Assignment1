package eg.edu.alexu.csd.datastructure.queue.cs26_cs61_cs17;

import org.junit.Test;

import static org.junit.Assert.*;

public class linkedListQueueTest {
    @Test
    public void mylinkedListQueueTest()
    {
        linkedListQueue q = new linkedListQueue();
        assertEquals(0, q.size()); // still empty
        assertTrue(q.isEmpty());
        try {
            assertEquals(10, q.dequeue());
        }catch (IllegalStateException e)
        {
            assertEquals("Queue is empty",e.getMessage());  // give you exception when u use dequeue with empty exception
        }
        q.enqueue(10);
        assertEquals(1, q.size());
        q.enqueue(11);
        q.enqueue(12);
        q.enqueue(13);
        assertEquals(4, q.size());
        q.enqueue('A');
        assertEquals(5, q.size());

        assertEquals(10, q.dequeue());
        assertEquals(11, q.dequeue());
        assertEquals(12, q.dequeue());
        assertEquals(13, q.dequeue());
        assertEquals('A', q.dequeue());
        assertTrue(q.isEmpty());  // check if the queue is empty
        try {
            assertEquals(10, q.dequeue());
        }catch (IllegalStateException e)
        {
            assertEquals("Queue is empty",e.getMessage());  // give you exception when u use dequeue with empty exception
        }

    }
    @Test(expected=IllegalStateException.class)
    public void testIllegalStateException()  {
        arrQueue q = new arrQueue(2);
        q.enqueue(11);
        q.enqueue(12);
        q.enqueue(12);
    }

}