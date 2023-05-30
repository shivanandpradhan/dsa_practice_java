package heap;

public class BinaryHeap {

    public int[] arr;
    int sizeOfTree;
    String heapType;

    BinaryHeap(int capacity, String heapType){
        arr = new int[capacity + 1];
        sizeOfTree = 0;
        this.heapType = heapType;
    }

    public Boolean isEmpty(){
        return sizeOfTree < 1 ? true : false;
    }
    
    public int peekOfHeap(){
        if(isEmpty()) {
            System.out.println("Heap is Empty");
            return -1;
        }
        return arr[1];
    }

    public int size(){
        return sizeOfTree;
    }

    public void levelOrderTraversal(){
        for(int i = 1; i <= sizeOfTree; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void heapifyBottomToTop(int index, String heapType){
        while(index > 0){
            int parent = index / 2;
            int value = arr[index];
            if (heapType == "MIN"){
                if(arr[parent] <= value) break;
                arr[index] = arr[parent];
                arr[parent] = value;
            } else if (heapType == "MAX") {
                if(arr[parent] >= value) break;
                arr[index] = arr[parent];
                arr[parent] = value;
            }
            index = parent;
        }
    }

    public void heapifyTopToBottom(int currIndex, String heapType){
        int leftChild, rightChild;

        // until current index less than size of tree, movement can occur to bottom
        while(currIndex < sizeOfTree){

            leftChild = currIndex << 1;             // left child position for currIndex
            if(leftChild > sizeOfTree) break;       // if no left child exists, then no further heapify action

            rightChild = leftChild + 1;             // finding right child

            int swapChild = -1;

            if(heapType == "MIN"){

                // left child equals size of tree, then only left child is possible
                if(leftChild == sizeOfTree){
                    if(arr[leftChild] < arr[currIndex]){
                        int temp = arr[leftChild];
                        arr[leftChild] = arr[currIndex];
                        arr[currIndex] = temp;
                    }
                    return;
                } else {                                    // both children exists.
                    if (arr[leftChild] < arr[rightChild]){
                        swapChild = leftChild;
                    } else {
                        swapChild = rightChild;
                    }
                    
                    if(arr[swapChild] < arr[currIndex]){
                        int temp = arr[currIndex];
                        arr[currIndex] = arr[swapChild];
                        arr[swapChild] = temp;
                    } else {
                        swapChild = -1;
                    }
                }
            } else if (heapType == "MAX"){

                if (leftChild == sizeOfTree) {
                    if(arr[leftChild] > arr[currIndex]){
                        int temp = arr[leftChild];
                        arr[leftChild] = arr[currIndex];
                        arr[currIndex] = temp;
                    }
                    return;
                } else {

                    if (arr[leftChild] > arr[rightChild]){
                        swapChild = leftChild;
                    } else {
                        swapChild = rightChild;
                    }

                    if(arr[currIndex] < arr[swapChild]){
                        int temp = arr[currIndex];
                        arr[currIndex] = arr[swapChild];
                        arr[swapChild] = temp;
                    } else {
                        swapChild = -1;
                    }
                }
            }
            if (swapChild == -1) break;
            currIndex = swapChild;
        }
    }

    public void insertInHeap(int value){
        if (sizeOfTree == arr.length){
            System.out.println("No Element inserted. Heap Size is full");
            return;
        } 
        arr[++sizeOfTree] = value;
        heapifyBottomToTop(sizeOfTree, heapType);
    }

    public int extractNodeFromHeap(){
        if(isEmpty()) {
            System.out.println("Heap is Empty.");
            return -1;
        }
        int result = peekOfHeap();
        
        // replace this with the last value;
        arr[1] = arr[sizeOfTree];
        sizeOfTree--;

        // heapify from top to bottom
        heapifyTopToBottom(1, heapType);
        return result;
    }

    public void deleteBinaryHeap(){
        this.arr = null;
        sizeOfTree = 0;
        System.out.println("Binary Heap deleted Successfully.");
    }
}
