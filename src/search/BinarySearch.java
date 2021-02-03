package search;

/**
 * Given a sorted array arr[] of n elements, write a function to search a given element x in arr[].
 */
public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(BinarySearch.search(new int[]{ 2, 3, 4, 10, 40 }, 10));
        System.out.println(BinarySearch.search(new int[]{ 2, 3, 4, 10, 40 }, 50));
    }

    public static boolean search(int[] array, int element) {
        return search(array, element, 0, array.length-1);
    }

    public static boolean search(int[] array, int element, int low, int high) {

        while (low <= high){
            int mid = (low+high)/2;
            if (element > array[mid]){
                low = mid+1;
            } else if (element < array[mid]){
                high = mid -1;
            } else {
                return true;
            }
        }
        return false;
    }
}
