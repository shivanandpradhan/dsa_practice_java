package stack;

import sll.SingleLinkedList;

public class StackUsingLinkedList {
    
    SingleLinkedList sll;

    public StackUsingLinkedList(){
        sll = new SingleLinkedList();
    }

    public Boolean isEmpty(){
        return sll.head == null;
    }

    public void push(int x){
        sll.insertInLinkedList(x, 0);
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty.");
            return Integer.MIN_VALUE;
        } 

        int result = sll.head.data;
        sll.deleteNodeInLinkedList(0);
        return result;
    }
    
    public int peek(){
        if (isEmpty()){
            System.out.println("Stack is empty.");
            return Integer.MIN_VALUE;
        }
        return sll.head.data;
    }

    public void deleteStack(){
        sll.deleteAllLinkedList();
        System.out.println("Stack Deleted Successfully.");
    }
}
