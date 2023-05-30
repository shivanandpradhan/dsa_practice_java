package dll;

public class DoubleLinkedList {
    
    public Node head;
    public Node tail;
    public int size;

    /**
     * create double linked list
     * @param value
     * @return
     */
    public Node createDoubleLinkedList(int value){
        Node node = new Node();
        node.data = value;
        node.next = null;
        node.prev = null;
        head = node;
        tail = node;
        size = 1; 
        return head;
    }

    /**
     * insert node with value at given location.
     * @param value
     * @param location
     */
    public void insertNodeInDLL(int value, int location){
        if(head == null){
            createDoubleLinkedList(value);
            return;
        }

        Node node = new Node();
        node.data = value;

        if(location == 0) {                     // insert at first position;
            node.next = head;
            head.prev = node;
            head = node;
        } else if (location >= size){           // insert at last position
            tail.next = node;
            node.prev = tail;
            tail = node;
        } else {                                // insert in middle (location)
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++){
                tempNode = tempNode.next;
            }
            node.prev = tempNode;
            node.next = tempNode.next;
            tempNode.next.prev = node;
            tempNode.next = node;
        }
        size++;
    }


    /**
     * traverse double linked list.
     */
    public void traverseDLL(){
        if (head == null){
            System.out.println("DLL is empty.");
            return;
        } 
        Node tempNode = head;
        while(tempNode.next != null){
            System.out.print(tempNode.data + " -> ");
            tempNode = tempNode.next;
        }
        System.out.println(tempNode.data);
    }

    /** 
     * reverse Traversal for dll
     */
    public void reverseTraversalDLL(){
        if (head == null){
            System.out.println("DLL is empty.");
            return;
        }
        Node tempNode = tail;
        while(tempNode.prev != null){
            System.out.print(tempNode.data + " -> ");
            tempNode = tempNode.prev;
        }
        System.out.println(tempNode.data);
    }

    /**
     * search node with value in DLL
     * @param value
     */
    public Boolean searchNodeInDLL(int value){
        if(head == null) return false;
        Node tempNode = head;
        for(int i = 0; i < size; i++){
            if (tempNode.data == value){
                System.out.println(String.format("%d - Found at location : %d", value, i));
                return true;
            }
            tempNode = tempNode.next;
        }
        System.out.println("Not Found : " + value);
        return false;
    }

    /**
     * delete node from the DLL
     */
    public void deleteNodeInDLL(int location){
        if(head == null){ 
            System.out.println("DLL is empty. Can't be delete");
            return;
        }

        if(size == 1){
            head = tail = null; 
            size--; return;
        }

        if(location == 0){                          // delete first node
            head = head.next;
            head.prev = null;
        } else if(location >= size - 1){            // delete last node
            tail = tail.prev;
            tail.next = null;
        } else {                                    // delete middle (location)
            Node tempNode = head;
            for(int i = 0; i < location - 1; i++){
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            tempNode.next.prev = tempNode;
        } 
        size--;
    }

    /**
     * delete all Doubly Linked List
     */
    public void deleteAllDLL(){
        head = tail = null;
        size = 0;
    }
}
