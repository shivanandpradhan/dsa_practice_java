package sll;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        sll.createLinkedList(5);
        System.out.println(sll.head.data);
        sll.insertInLinkedList(6, 1);
        sll.insertInLinkedList(10, 0);
        sll.insertInLinkedList(20, 1);
        // sll.deleteAllLinkedList();
        sll.traverseLinkedList();
        sll.deleteNodeInLinkedList(12);
        sll.traverseLinkedList();

        // CircularSingleLinkedList csll = new CircularSingleLinkedList();
        // csll.createCircularSingleLinkedList(10);
        // csll.insertNodeInCircularSLL(5, 0);
        // csll.insertNodeInCircularSLL(20, 2);
        // csll.insertNodeInCircularSLL(15, 2);
        // csll.traverseCircularSLL();
        // csll.searchNodeInCircularSLL(20);
        // csll.deleteNodeInCircularSLL(3);
        // csll.traverseCircularSLL();
        // csll.deleteNodeInCircularSLL(1);
        // csll.traverseCircularSLL();
        // csll.deleteNodeInCircularSLL(0);
        // csll.traverseCircularSLL();

    }
}
