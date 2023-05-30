package search;

public class Search {

    public Boolean binarySearch(int[] arr, int val){
        return binarySearchRecursive(arr, 0, arr.length - 1, val);
    }

    private Boolean binarySearchRecursive(int [] arr, int left, int right, int val){
        int mid = (left + right) / 2;
        if (arr[mid] == val) return true;
        if(left >= right) return false;
        return binarySearchRecursive(arr, left, mid, val) || binarySearchRecursive(arr, mid + 1, right, val);
    }
}
