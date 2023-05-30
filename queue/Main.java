package queue;

public class Main {
    public static void main(String[] args) {
        // Queue que = new Queue(5);
        // que.enqueue(10);
        // System.out.println("Queue is Empty : " + que.isEmpty());
        // System.out.println("Queue is Full : " + que.isFull());
        // que.enqueue(20);
        // System.out.println("Dequeue : " + que.dequeue());
        // System.out.println("Dequeue : " + que.dequeue());
        // System.out.println("Peek : " + que.peek());

        // CircularQueue que1 = new CircularQueue(5);
        // que1.enqueue(0);
        // System.out.println("Queue is Empty : " + que1.isEmpty());
        // System.out.println("Queue is Full : " + que1.isFull());
        // que1.enqueue(1);
        // que1.enqueue(2);
        // que1.enqueue(3);
        // que1.enqueue(4);
        // System.out.println("Queue is Full : " + que1.isFull());
        // System.out.println(que1.dequeue());
        // que1.enqueue(6);
        // // que1.enqueue(7);
        // System.out.println(que1.dequeue());
        // for(int i : que1.arr){
        //     System.out.print(i + ", ");
        // }
        // System.out.println();
        // System.out.println(que1.dequeue());
        // System.out.println(que1.dequeue());
        // System.out.println(que1.dequeue());
        // System.out.println(que1.dequeue());
        // System.out.println("Queue Top : " + que1.peek());
        // for(int i : que1.arr){
        //     System.out.print(i + ", ");
        // }
        // System.out.println();

        QueueLL que2 = new QueueLL();
        System.out.println("Queue is empty " + que2.isEmpty());
        que2.enqueue(10);
        que2.enqueue(20);
        que2.enqueue(30);
        System.out.println("Queue Top : " + que2.peek());
        System.out.println(" Queue Dequed : " + que2.dequeue());
        System.out.println(" Queue Dequed : " + que2.dequeue());
        System.out.println("Queue Top : " + que2.peek());
    }
}
