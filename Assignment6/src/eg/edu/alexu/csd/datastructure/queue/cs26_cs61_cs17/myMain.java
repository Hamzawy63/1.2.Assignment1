package eg.edu.alexu.csd.datastructure.queue.cs26_cs61_cs17;

public class myMain {

    public static void main(String[] args) {
        linkedListQueue q = new linkedListQueue();
        q.enqueue(10);
        System.out.println(q.isEmpty()); // no
        q.enqueue(10);
        System.out.println(q.isEmpty()); // no
        q.enqueue(10);
        q.enqueue(10);

        System.out.println(q.size()); //4
        System.out.println(q.dequeue());; // 7

    }
}
