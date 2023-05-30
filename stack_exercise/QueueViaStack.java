package stack_exercise;

import java.util.Stack;

public class QueueViaStack {
    public Stack<Integer> stk;

    QueueViaStack(){
        stk = new Stack<>();
    }

    /*
     * Enqueue operation.
     */
    public void enqueue(int value){
        stk.push(value);
    }

    /**
     * Dequeue Operation.
     * @return
     */
    public int dequeue(){
        if (stk.empty()) return -1;

        Stack<Integer> stk2 = new Stack<>();
        while(!stk.isEmpty()){
            stk2.push(stk.pop());
        }

        int result = stk2.pop();
        while(!stk2.isEmpty()){
            stk.push((stk2.pop()));
        }
        return result;
    }
}