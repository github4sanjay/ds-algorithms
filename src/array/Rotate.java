package array;

import java.util.Arrays;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Follow up:
 *
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 */
public class Rotate {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        rotateClockWise(arr, 3);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = new int[]{1,2,3,4,5,6,7};
        rotateAntiClockWise(arr1, 3);
        System.out.println(Arrays.toString(arr1));
    }

    public static void rotateAntiClockWise(int[] arr, int k) {
        int i=0, j= arr.length-k-1;
        while (i < j){
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            i++; j--;
        }

        i=arr.length-k;
        j= arr.length-1;
        while (i < j){
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            i++; j--;
        }

        i=0;
        j= arr.length-1;
        while (i < j){
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            i++; j--;
        }
    }

    public static void rotateClockWise(int[] arr, int k) {

        int i=0;
        int j= arr.length-1;
        while (i < j){
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            i++; j--;
        }

        i=0;
        j= arr.length-k-1;
        while (i < j){
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            i++; j--;
        }

        i=arr.length-k;
        j= arr.length-1;
        while (i < j){
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            i++; j--;
        }
    }
}
