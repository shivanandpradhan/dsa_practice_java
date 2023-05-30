package queue;

public class Queue {
    public int[] arr;
    int topOfQueue;
    int beginningOfQueue;

    public Queue(int size){
        arr = new int[size];
        topOfQueue = -1;
        beginningOfQueue = -1;
    }

    public Boolean isEmpty(){
        return beginningOfQueue == -1 || beginningOfQueue == arr.length;
    }

    public Boolean isFull(){
        return topOfQueue == arr.length - 1;
    }

    public void enqueue(int x){
        if (isFull()){
            System.out.println("Queue is Full. No Enqueue Operation");
            return;
        } 
        // when first element enqueue, begining of queue = 0
        if (isEmpty()) beginningOfQueue = 0;
        arr[++topOfQueue] = x;
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty. No Dequeue Operation.");
            return Integer.MIN_VALUE;
        } else{
            int result = arr[beginningOfQueue];
            beginningOfQueue++;
            if(beginningOfQueue > topOfQueue){
                beginningOfQueue = topOfQueue = -1;
            }
            return result;
        }
    }

    public void deleteQueue(){
        arr = null;
        beginningOfQueue = topOfQueue = -1;
        System.out.println("Queue Deleted Successfully."); 
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is Empty. No Peek Operation");
            return Integer.MIN_VALUE;
        }
        return arr[beginningOfQueue];
    }
}
