package sll;

public class CircularSingleLinkedList {

    public Node head;
    public Node tail;
    public int size;

    /**
     * create circular sll with initial value
     * @param value
     * @return
     */
    public Node createCircularSingleLinkedList(int value) {
        Node newNode = new Node();
        newNode.data = value;
        newNode.next = newNode;
        head = newNode;
        tail = newNode;
        size = 1;
        return head;
    }

    /**
     * insert node in circular single linked list
     * @param value
     * @param location
     */
    public void insertNodeInCircularSLL(int value, int location){
        if(head == null){
            createCircularSingleLinkedList(value);
            return;
        }

        Node newNode = new Node(value, null);

        if(location == 0){                              // insert at first position
            newNode.next = head;
            head = newNode;
            tail.next = newNode;
        } else if (location >= size){                   // insert at last position
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        } else {                                        // insert in middle (location)
            Node tempNode = head;
            for(int i = 0; i < location - 1; i++){
                tempNode = tempNode.next;
            }
            newNode.next = tempNode.next;
            tempNode.next = newNode;
        }
        size++;
    }

    /**
     * search node in circular single list.
     * @param nodeValue
     * @return
     */
    public Boolean searchNodeInCircularSLL(int nodeValue){
        if(head == null) return false;
        Node tempNode = head;
        for(int i = 0; i < size; i++){
            if(tempNode.data ==  nodeValue){
                System.out.format("%d - found at location : %d\n",nodeValue,i);
                return true;
            }
            tempNode = tempNode.next;
        }
        System.out.println("Node not found with : " + nodeValue);
        return false;
    }

    /**
     * traverse circular sll
     */
    public void traverseCircularSLL(){
        if(head == null) {
            System.out.println("Circular Sll is Empty.");
            return;
        }
        Node tempNode = head;
        while(tempNode.next != head){
            System.out.print(tempNode.data + " -> ");
            tempNode = tempNode.next;
        }
        System.out.println(tempNode.data);
    }

    /**
     * delete node from circular single linked list
     * @param location
     */
    public void deleteNodeInCircularSLL(int location){
        if (head == null){
            System.out.println("Circular SLL is empty. Can't be delete");
            return;
        }
        
        // base case
        if(size == 1){
            head = tail = null;
            size --;
            return;
        } 

        // removing first node;
        if (location == 0){
            head = head.next;
            tail.next = head;
        } else if(location >= size - 1){               // remove last node
            Node tempNode = head;
            for(int i = 1; i < size - 1; i++){
                tempNode = tempNode.next;
            }
            tempNode.next = head;
            tail = tempNode;
        } else{                                   // remove middle node - (location)
            Node tempNode = head;
            for(int i = 0; i < location - 1; i++){
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
        }
        size--;
    }

    /**
     * delete all circular single linked list.
     */
    public void deleteAllCircularSLL(){
        head = tail = null;
        size = 0;
    }

}
