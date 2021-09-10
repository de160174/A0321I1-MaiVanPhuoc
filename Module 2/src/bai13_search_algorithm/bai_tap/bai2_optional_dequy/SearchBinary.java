package bai13_search_algorithm.bai_tap.bai2_optional_dequy;

public class SearchBinary {
    public int binarySearch(int[] arr, int value, int left, int right) {
        if (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] > value) {
                return binarySearch(arr, value, left, mid - 1);
            } else {
                return binarySearch(arr, value, mid + 1, right);
            }
        } else {
            return -1;
        }
    }
    public static void main(String[] args) {
        SearchBinary searchBinary=new SearchBinary();
        int[] arr={1,4,7,3,23,2,98,67};
        System.out.println(searchBinary.binarySearch(arr,4,0,arr.length-1));
    }
}
