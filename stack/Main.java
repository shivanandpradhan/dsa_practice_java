package stack;

public class Main {
    public static void main(String[] args) {
        // StackUsingArray stack = new StackUsingArray(5);
        // System.out.println("Stack is Empty : " + stack.isEmpty());
        // System.out.println("Stack is Full : " + stack.isFull());
        // stack.push(5);
        // stack.push(10);
        // stack.pop();
        // stack.peek();

        StackUsingLinkedList stack1 = new StackUsingLinkedList();
        stack1.push(10);
        stack1.push(20);
        System.out.println("Poped : " + stack1.pop());
        System.out.println("Peek : " + stack1.peek());
        System.out.println("Poped : " + stack1.pop());
        System.out.println("Peek : " + stack1.peek());
        stack1.push(200);
        stack1.deleteStack();
        System.out.println("Peek : " + stack1.peek());
    }
}
