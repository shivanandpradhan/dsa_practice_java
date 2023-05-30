package ll_excercise;

public class LinkedList {
    public Node head;
    public Node tail;
    public int size;

    public Node createLinkedList(int value){
        Node node = new Node();
        node.value = value;
        node.next = node.prev = null;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void insertNode(int value){
        if (head == null){
            createLinkedList(value); return;
        } 
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = null;
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void traverseLinkedList() {
        Node tempNode = head;
        for (int i =0; i<size; i++) {
          System.out.print(tempNode.value);
          if (i != size -1) {
            System.out.print(" -> ");
          }
          tempNode = tempNode.next;
        }
        System.out.println();
      }
}
