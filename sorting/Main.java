package sorting;

public class Main {
    public static void main(String[] args) {
        
        int[] arr = {7,5,1,6,3,8,9,4};
        // int[] arr1 = {3,4,5,6,1,2,3};
        // Sort.bubbleSort(arr);
        // Sort.selectionSort(arr);
        // Sort.insertionSort(arr);
        // Sort.bucketSort(arr);
        // Sort.mergeSort(arr1, 0, arr1.length - 1);
        // Sort.partitionArrayUsingPivot(arr, 0, arr.length - 1);
        Sort.quickSort(arr, 0, arr.length - 1);
        
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
}
