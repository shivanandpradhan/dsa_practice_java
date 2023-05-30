package stack_exercise;

public class Main {
    
    public static void main(String[] args) {
        ThreeInOne stk = new ThreeInOne(12);
        System.out.println("Stack1 is Empty : " + stk.isEmpty(1));
        stk.push(1, 10);
        stk.push(1, 20);
        stk.push(1, 30);
        stk.push(2, 40);
        // stk.pop(1);
        stk.print();
        stk.printArray();
        System.out.println("Stack 1 Top : " + stk.peek(1));
        System.out.println("Stack 1 Top : " + stk.peek(1));
        System.out.println("Stack 2 Top : " + stk.peek(2));
    }
}
