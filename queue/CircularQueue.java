package queue;

public class CircularQueue {
    
    public int arr[];
    public int topOfQueue;
    public int beginningOfQueue;
    public int size;

    public CircularQueue(int size){
        arr = new int[size];
        topOfQueue = -1;
        beginningOfQueue = -1;
        this.size = size;
    }

    public Boolean isEmpty(){
        return topOfQueue == -1;
    }

    public Boolean isFull(){
        return (topOfQueue + 1 == beginningOfQueue) || (beginningOfQueue == 0 && topOfQueue == size - 1);
    }

    public void enqueue(int x){
        if(isFull()){
            System.out.println("Queue is Full. No Enqueue Operation.");
            return;
        }
        if(isEmpty()) beginningOfQueue = 0;
        topOfQueue = topOfQueue + 1 == size ? 0 : topOfQueue + 1;
        arr[topOfQueue] = x;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is Empty.");
            return Integer.MIN_VALUE;
        }
        return arr[beginningOfQueue];
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty. No Deque Operation.");
            return Integer.MIN_VALUE;
        }
        int result = arr[beginningOfQueue];
        if (beginningOfQueue == topOfQueue) {
            beginningOfQueue = topOfQueue = -1;
        } else{
            beginningOfQueue = (beginningOfQueue + 1) % size;
        }
        return result;
    }
}
