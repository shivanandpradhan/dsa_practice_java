package sorting;

import java.util.ArrayList;

public class Sort {

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * bubble sort method
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        boolean flag = true;
        for (int j = arr.length; j > 0; j--){
            for(int i = 0; i < arr.length - 1; i++){
                if (arr[i] > arr[i + 1]){
                    swap(arr, i, i+1);
                    flag = false;
                }
            }
            if(flag == true) return;
            else flag = true;
        }
    }

    /** 
     * selection sort method
     */
    public static void selectionSort(int [] arr){
        for (int i = 0; i < arr.length; i++){
            int minIndex = i;
            for(int j = i+1; j < arr.length; j++){
                if (arr[minIndex] > arr[j]) minIndex = j;
            }
            if(minIndex != i){
                swap(arr, i, minIndex);
            }
        }
    }

    /**
     * insertion sort method
     */
    public static void insertionSort(int [] arr){
        for(int i = 1; i < arr.length; i++){
            int temp = i;
            for(int j = i - 1; j >= 0 && arr[j] > arr[temp]; j--){
                swap(arr, j, temp);
                temp -= 1;
            }
        }
    }


    public static void printBucket(ArrayList<Integer> [] buckets){
        System.out.print("[ ");
        for(int i = 0; i < buckets.length; i++){
            System.out.print("[");
            for (int x : buckets[i]){
                System.out.print(x + ", ");
            }
            System.out.print("], ");
        }
        System.out.println(" ]");
    }

    // bucket sort.
    public static int[] bucketSort(int[] arr){
        int numOfBuckets = (int) Math.ceil(Math.sqrt(arr.length));
        int maxVal = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if (maxVal < arr[i]) maxVal = arr[i];
        }

        // creating buckets of integer
        ArrayList<Integer> [] buckets = new ArrayList[numOfBuckets];
        for(int i = 0; i < numOfBuckets; i++){
            buckets[i] = new ArrayList<>();
        }

        for(int i = 0; i < arr.length; i++){
            int bucketNum = (arr[i] * numOfBuckets) / maxVal;
            if(bucketNum == numOfBuckets){
                buckets[bucketNum - 1].add(arr[i]);
            } else {
                buckets[bucketNum].add(arr[i]);
            }
        }

        // print bucket data
        printBucket(buckets);

        // apply insertion sort on each bucket
        for( int i = 0; i < buckets.length; i++){
            for(int j = 1; j < buckets[i].size(); j++){
                for(int k = j - 1; k >= 0; k--){
                    if(buckets[i].get(j) < buckets[i].get(k)){
                        int temp = buckets[i].get(j);
                        buckets[i].set(j, buckets[i].get(k));
                        buckets[i].set(k, temp);
                    } else {
                        break;
                    }
                }
            }
        }

        // merge each sorted buckets
        int pos = 0;
        for(int i = 0; i < buckets.length; i++){
            for(int x : buckets[i]){
                arr[pos++] = x;
            }
        }

        return arr;
    }


    // two sorted arr;
    public int[] merge(int [] arr1, int [] arr2){
        int [] res = new int[arr1.length + arr2.length];
        
        int i = 0, j = 0, k = 0;
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] > arr2[j]){
                res[k++] = arr2[j];
                j++;
            } else {
                res[k++] = arr1[i];
                i++;
            }
        }

        while(i < arr1.length){
            res[k++] = arr1[i++];
        } 

        while(j < arr2.length){
            res[k++] = arr2[j++];
        }

        return res;
    }

    // merge sort algorithm
    public static void mergeSort(int [] arr, int left, int right){
        if(left < right){
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            mergeArr(arr, left, middle, right);
        }
    }


    public static void mergeArr(int [] arr, int left, int middle, int right){
        int [] leftArr = new int[middle - left + 1];
        int [] rightArr = new int[right - middle];

        // left arr initialize
        for(int i = 0; i < leftArr.length; i++){
            leftArr[i] = arr[left + i];
        }
        
        // right arr initialize
        for(int j = 1; j <= rightArr.length; j++){
            rightArr[j - 1] = arr[middle + j];
        }

        int m = 0, n = 0;
        int pos = left;

        while(m < leftArr.length && n < rightArr.length){
            if(leftArr[m] < rightArr[n]){
                arr[pos++] = leftArr[m++];
            } else {
                arr[pos++] = rightArr[n++];
            }
        }
        while(m < leftArr.length){
            arr[pos++] = leftArr[m++];
        }
        while(n < rightArr.length){
            arr[pos++] = rightArr[n++];
        }
    }

    // quick sort algorithm
    public static void quickSort(int arr[], int left, int right) {
        if(left < right){
            // int pivotPos = partitionArrayUsingPivot(arr, left, right);
            int pivotPos = partition(arr, left, right);
            quickSort(arr, left, pivotPos - 1);
            quickSort(arr, pivotPos + 1, right);
        }
    }

    // partition arr using pivot element and return index of pivot
    public static int partitionArrayUsingPivot(int arr[], int left, int right){
        int pivot = arr[left];
        
        int i = left + 1;
        int j = right;
        boolean leftMove = true;
        boolean rightMove = false;

        while(i <= j){
            if(leftMove){
                if(arr[i] > pivot) {
                    leftMove = false;
                    rightMove = true;
                }
                else i++;
            }else if(rightMove){
                if(arr[j] < pivot) {
                    rightMove = false;
                }
                else j--;
            } else {
                swap(arr, i, j);
                leftMove = true;
            }
        }
        swap(arr, left, j);
        return j;
    }

    // partition arr
    public static int partition(int [] arr, int left, int right){
        int pivot = left;
        int k = right + 1;
        for(int j = right; j >= 0; j--){
            if(arr[j] >= arr[pivot]){
                k--;
                swap(arr, j, k);
            }
        }
        return k;
    }
}