package search;

public class FindPivotInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(findPivot(new int[]{5, 6, 7, 8, 9, 10, 1, 2, 3}));
        System.out.println(findPivot(new int[]{5, 6, 7, 8, 9, 10, 11, 2, 3}));
        System.out.println(findPivot(new int[]{5, 16, 17, 18, 1, 2, 3}));
    }

    public static int findPivot(int[] array) {
        int low=0, high=array.length-1;
        while (low<=high){
            int mid = (low+high)/2;

            if (array[mid] > array[mid-1] && array[mid] > array[mid+1]){
                return mid;
            } else if (array[low] < array[mid]){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return 0;
    }
}
