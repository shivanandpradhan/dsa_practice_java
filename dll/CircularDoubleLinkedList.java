package dll;

public class CircularDoubleLinkedList {
    
    public Node head;
    public Node tail;
    public int size;

    /**
     * create circular double linked list.
     * @param value
     * @return
     */
    public Node createCircularDoubleLinkedList(int value){
        Node node = new Node();
        node.data = value;
        node.prev = node.next = node;
        size = 1;
        head = node;
        tail = node;
        return head;
    }

    /**
     * insert node with given value at given location.
     * @param value
     * @param location
     */
    public void insertNodeInCircularDLL(int value, int location) {
        if (head == null){
            createCircularDoubleLinkedList(value);
            return;
        }

        Node newNode = new Node();
        newNode.data = value;

        // insert at first position
        if (location == 0){
            // newnode next to first element and prev to last element
            newNode.next = head;
            newNode.prev = tail;
            // head prev to points to new node
            head.prev = newNode;
            head = newNode;
            // changing tail next to newNode
            tail.next = newNode;
        }
        else if (location >= size){
            // newNode prev to last node and new node next points to head;
            newNode.prev = tail;
            newNode.next = head;
            // tail next points to new node and finally tail is new node
            tail.next = newNode;
            tail = newNode;
            // head prev points to new tail. (circular dLL)
            head.prev = tail;
        } else {
            Node tempNode = head;
            for(int i = 0; i < location - 1; i++){
                tempNode = tempNode.next;
            } 
            //new node next to tempnode next and prev to tempnode
            newNode.next = tempNode.next;
            newNode.prev = tempNode;
            // tempNode next prev  points to new node and tempnode next to new node
            tempNode.next.prev = newNode;
            tempNode.next = newNode;
        }
        size++;
    }
   
    /**
     * traverse through the circular double linked list.
     */
    public void traverseCDLL(){
        if (head == null){
            System.out.println("Circular Double Linked List is Empty");
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
     * traverse through the circular double linked list in reverse order;
     */
    public void reverseTraverseCDLL(){
        if (head == null){
            System.out.println("Circular Double Linked List is Empty");
            return;
        }
        Node tempNode = tail;
        while(tempNode.prev != tail){
            System.out.print(tempNode.data + " -> ");
            tempNode = tempNode.prev;
        }
        System.out.println(tempNode.data);
    }

    public void deleteNodeInCDLL(int location){
        if(head == null){
            System.out.println("CDLL is empty. Delete can't be done");
        }

        if(size == 1){
            head = tail = null;
            size = 0;
            return;
        }

        if(location == 0){
            head = head.next;
            // head prev points to tail and tail next points to head;
            head.prev = tail;
            tail.next = head;
        } else if (location >= size - 1){
            // tail points to tail prev 
            tail = tail.prev;
            // tail next points to head and head prev point to new tail;
            tail.next = head;
            head.prev = tail;
        } else {
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
     * delete all circular DLL
     */
    public void deleteAllCDLL(){
        head = tail = null;
        size = 0;
        System.out.println("CDLL is deleted successfully!!");
    }
}
