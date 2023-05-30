package sll;

public class SingleLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public SingleLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public Node createLinkedList(int value){
        Node node = new Node();
        node.data = value;
        node.next = null;
        size = 1;
        head = node;
        tail = node;
        return head;
    }
    
    public void insertInLinkedList(int value, int location){
        
        if(head == null){
            createLinkedList(value);
            return;
        }

        // create a node
        Node newNode = new Node(value, null);

        // location <= 0 - insert at first
        if (location <= 0){
            newNode.next = head;
            head = newNode;
        } 
        // location >= size - insert at end
        else if(location >= size){
            tail.next = newNode;
            tail = newNode;
        } 
        // location -- iterate and insert node
        else{
            Node temp = head;
            for(int i = 1; i < location; i++){
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        // increment size
        size++;
    }

    public void traverseLinkedList(){
        if (head == null) {
            System.out.println("SLL is empty");
        } else {
            Node tempNode = head;
            while(tempNode.next != null){
                System.out.print(tempNode.data + " -> ");
                tempNode = tempNode.next;
            }
            System.out.println(tempNode.data);
        }
    }

    public Boolean searchNode(int value){
        if(head == null) return false;
        Node tempNode = head;
        while(tempNode != null){
            if (tempNode.data == value){
                return true;
            }
            tempNode = tempNode.next;
        }
        return false;
    }

    public void deleteNodeInLinkedList(int location){
        if (location > size) location = size - 1;
        if (head == null){
            System.out.println("Sll is empty. Delete can't be done");
            return;
        } else if (location == 0 || size == 1){
            head = head.next;
            if (size == 1) tail = null;
        } else {
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++){
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            if(location == size - 1) tail = tempNode;
        }
        size--;
    }

    public void deleteAllLinkedList(){
        head = tail = null;
        size = 0;
    }
}
