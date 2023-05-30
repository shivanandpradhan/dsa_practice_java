package dll;

public class Main {
    public static void main(String[] args) {
        // DoubleLinkedList dll = new DoubleLinkedList();
        // dll.createDoubleLinkedList(10);
        // dll.insertNodeInDLL(5, 0);
        // dll.insertNodeInDLL(40, 2);
        // dll.insertNodeInDLL(30, 1);
        // dll.insertNodeInDLL(20, 3);
        // dll.traverseDLL();
        // dll.reverseTraversalDLL();
        // System.out.println(dll.tail.prev.data);
        // dll.searchNodeInDLL(10);
        
        // dll.traverseDLL();
        // dll.deleteNodeInDLL(5);
        // dll.traverseDLL();
        // dll.deleteNodeInDLL(1);
        // dll.traverseDLL();
        // dll.deleteNodeInDLL(0);
        // dll.traverseDLL();
        // dll.reverseTraversalDLL();
        // System.out.println("size of dll : " + dll.size);

        CircularDoubleLinkedList cdll = new CircularDoubleLinkedList();
        cdll.createCircularDoubleLinkedList(40);
        cdll.insertNodeInCircularDLL(20, 0);
        cdll.insertNodeInCircularDLL(25, 1);
        cdll.insertNodeInCircularDLL(50, 3);
        cdll.insertNodeInCircularDLL(30, 2);
        cdll.traverseCDLL();
        cdll.deleteNodeInCDLL(0);
        cdll.traverseCDLL();
        cdll.deleteNodeInCDLL(3);
        cdll.traverseCDLL();
        cdll.deleteNodeInCDLL(1);
        cdll.traverseCDLL();
        cdll.deleteAllCDLL();
        cdll.traverseCDLL();
        System.out.println("size of circular DLL : " + cdll.size);
    }
}
