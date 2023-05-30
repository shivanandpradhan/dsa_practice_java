package stack_exercise;

public class StackMin {
  
  public Node head;

  public StackMin() {
    head = null;
  }

  public int min() {
    return head.min;
  }

  public void push(int value) {
    Node node = new Node();
    node.data = value;
    
    if(head == null){
        node.min = value;
        head = node;
    } else {
        node.next = head;
        node.min = head.min > value ? value : head.min;
        head = node;
    }
  }

  public int pop() {
    if(head == null){
        return -1;
    }
    int result = head.data;
    head = head.next;
    return result;
  }
}