package search;

import java.util.Arrays;

/**
 * Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
 *
 * Return the array in the form [x1,y1,x2,y2,...,xn,yn].
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,5,1,3,4,7], n = 3
 * Output: [2,3,5,4,1,7]
 * Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
 * Example 2:
 *
 * Input: nums = [1,2,3,4,4,3,2,1], n = 4
 * Output: [1,4,2,3,3,2,4,1]
 * Example 3:
 *
 * Input: nums = [1,1,2,2], n = 2
 * Output: [1,2,1,2]
 */
public class ShuffleAnArrayLengthIsInPowerOf2 {
    public static void main(String[] args) {
        var arr = new int[] {1,2,3,4,4,3,2,1};
        ShuffleAnArrayLengthIsInPowerOf2.shuffle(arr);
        System.out.println(Arrays.toString(arr));

        var arr1 = new int[] {1,1,2,2};
        ShuffleAnArrayLengthIsInPowerOf2.shuffle(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    // this only work when length is in power of 2
    private static void shuffle(int[] array) {
        shuffle(array, 0, array.length-1);
    }

    private static void shuffle(int[] array, int low, int high) {
        if (low == high){
            return;
        }
        int mid = (low+high)/2;
        shuffleUtil(array, low, mid);
        shuffle(array, low, mid);
        shuffle(array, mid+1, high);
    }

    /**
     *                1,2,3,4     |      4,3,2,1
     *                1,2,4,3     |      3,4,2,1
     *                1,2 | 4,3          3,4 | 2,1
     *                1,4 | 2,3          3,2 | 4,1
     */
    private static void shuffleUtil(int[] array, int low, int mid) {
        int q = 1+(low+mid)/2;
        for (int k=1,i=q;i<=mid; i++,k++){
            var temp = array[i];
            array[i] = array[mid+k];
            array[mid+k] = temp;
        }
    }
}
