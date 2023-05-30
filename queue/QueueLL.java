package queue;

import sll.SingleLinkedList;

public class QueueLL {
    
    public SingleLinkedList sll;

    QueueLL(){
        sll = new SingleLinkedList();
    }

    public Boolean isEmpty(){
        return sll.head == null;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is Empty. No Peek Operation");
            return Integer.MIN_VALUE;
        }
        return sll.head.data;
    }

    public void enqueue(int x){
        sll.insertInLinkedList(x, sll.size);
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty. No Deque Operation");
            return Integer.MIN_VALUE;
        }
        int result = sll.head.data;
        sll.deleteNodeInLinkedList(0);
        return result;
    }

}
