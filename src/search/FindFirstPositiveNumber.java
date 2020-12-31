package search;

/**
 * Find the first positive element in an array which is first negative and then positive numbers
 */
public class FindFirstPositiveNumber {

    public static void main(String[] args) {
        System.out.println(find(new int[]{-4, -3, -2, 4, 6, 8, 9}));
        System.out.println(find(new int[]{-4, -3, 2, 4, 6, 8, 9}));
        System.out.println(find(new int[]{-4, -3, -2, -4, 6, 8, 9}));
    }

    private static int find(int[] array) {
        int low=0;
        int high=array.length-1;
        while (low<=high){
            int mid = (low+high)/2;
            if(low == high){
                return array[low];
            }
            if (array[mid-1] < 0 && array[mid+1] < 0) {
                low = mid+1;
            } else if (array[mid-1] > 0 && array[mid+1] > 0) {
                high = mid-1;
            } else if (array[mid-1] < 0 && array[mid+1] > 0){
                return array[mid] < 0 ? array[mid+1] : array[mid];
            }
        }
        return 0;
    }
}
