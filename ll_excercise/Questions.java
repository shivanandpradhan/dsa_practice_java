package ll_excercise;

import java.util.HashSet;

public class Questions {

    /**
     * delete duplicates from the linked list using hashset
     * @param ll
     */
    public void deleteDuplicates(LinkedList ll){
        HashSet<Integer> hashSet = new HashSet<>();

        Node current = ll.head;
        Node prev = null;

        while(current != null){
            int currVal = current.value;
            if (hashSet.contains(currVal)){
                prev.next = current.next;
                ll.size--;
            } else{
                hashSet.add(currVal);
                prev = current;
            }
            current = current.next;
        }
    }

    public Node nthFromLastNode(LinkedList ll, int n) {
        if (ll.head == null){
            System.out.println("List is Empty.");
            return null;
        }
        if (n > ll.size || n < 1){
            System.out.println("Enter n from 1 to " + ll.size);
            return null;
        }
        
        Node temp = ll.head;
        for(int i = 0; i < ll.size - n; i++){
            temp = temp.next;
        }
        return temp;
    }

    /**
     * partition a linked list around a value x, 
     * such that all nodes less than x come before all nodes greater than or equal to x.
     * @param ll
     * @param x
     * @return
     */
    public LinkedList partition(LinkedList ll, int x){
        if(ll.head == null) return null;
        
        LinkedList result = new LinkedList();
        
        Node temp = ll.head;
        
        // creating first node
        result.createLinkedList(temp.value);
        temp = temp.next;
        
        while(temp != null){
            //inserting at end if value >= x
            if(temp.value >= x){
                result.insertNode(temp.value);
            } else{
                // inserting at the begining;
                Node newNode = new Node();
                newNode.value = temp.value;
                newNode.next = result.head;
                result.head = newNode;
                result.size++;
            }
            temp = temp.next;
        }
        return result;
    }
}
