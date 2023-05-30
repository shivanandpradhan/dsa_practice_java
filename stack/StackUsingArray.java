package stack;

public class StackUsingArray {
    
    int[] arr;
    int topOfStack;

    public StackUsingArray(int size){
        arr = new int[size];
        topOfStack = -1;
        System.out.println("Stack is created with size : " + size);
    }

    public Boolean isEmpty(){
        return topOfStack == -1;
    }

    public Boolean isFull(){
        return topOfStack == arr.length - 1;
    }

    public void push(int x){
        if(isFull()){
            System.out.println("Stack is full. No push Operation");
        } else{
            arr[++topOfStack] = x;
            System.out.println("Pushed : " + x);
        }
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty. No Pop Poeration");
            return Integer.MIN_VALUE;
        }
        System.out.println("Poped element : " + arr[topOfStack]);
        return arr[topOfStack--];
    }

    public int peek(){
        if(isEmpty()) {
            System.out.println("Stack is Empty. No Peek Operation.");
            return Integer.MIN_VALUE;
        } else{
            System.out.println("Peek : " + arr[topOfStack]);
            return arr[topOfStack];
        }
    }

    public void DeleteStack(){
        arr = null;
        topOfStack = -1;
        System.out.println("Stack Deleted Successfully.");
    }
}
