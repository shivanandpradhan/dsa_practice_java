package heap;

public class Main {
    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap(10, "MIN");
        heap.insertInHeap(10);
        heap.insertInHeap(20);
        heap.insertInHeap(34);
        heap.insertInHeap(21);
        heap.insertInHeap(16);
        heap.insertInHeap(51);
        heap.insertInHeap(5);
        heap.levelOrderTraversal();

        int sizeOfHeap = heap.size();
        System.out.println("Heap Size : " + sizeOfHeap);
        System.out.println( " Heap Sort : ");
        for(int i = 1; i <= sizeOfHeap; i++){
            System.out.print(heap.extractNodeFromHeap() + " ");
        }System.out.println();
    }
}
