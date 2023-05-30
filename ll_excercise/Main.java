package ll_excercise;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.createLinkedList(5);
        linkedList.insertNode(10);
        linkedList.insertNode(5);
        linkedList.insertNode(10);
        linkedList.insertNode(30);
        linkedList.traverseLinkedList();

        Questions que = new Questions();
        // que.deleteDuplicates(linkedList);
        // linkedList.traverseLinkedList();
        // System.out.println(que.nthFromLastNode(linkedList, 2).value);
        LinkedList ll1 = que.partition(linkedList, 20);
        ll1.traverseLinkedList();
    }
}
