package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given an array and an integer K, find the maximum for each and every contiguous subarray of size k.
 * Examples :
 *
 * Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3
 * Output: 3 3 4 5 5 5 6
 * Explanation:
 * Maximum of 1, 2, 3 is 3
 * Maximum of 2, 3, 1 is 3
 * Maximum of 3, 1, 4 is 4
 * Maximum of 1, 4, 5 is 5
 * Maximum of 4, 5, 2 is 5
 * Maximum of 5, 2, 3 is 5
 * Maximum of 2, 3, 6 is 6
 *
 * Input: arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, K = 4
 * Output: 10 10 10 15 15 90 90
 * Explanation:
 * Maximum of first 4 elements is 10, similarly for next 4
 * elements (i.e from index 1 to 4) is 10, So the sequence
 * generated is 10 10 10 15 15 90 90
 */
public class SlidingWindowMax {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(SlidingWindowMax.find(new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6}, 3))); // [3, 3, 4, 5, 5, 5, 6]
    }

    /**
     * index - {0, 1, 2, 3, 4, 5, 6, 7, 8}
     * array - {1, 2, 3, 1, 4, 5, 2, 3, 6}
     * nge -   {1, 2, 4, 4, 5, 8, 7, 8, 9} <----- if not next greater than array.length so that its out of window
     *
     *  for position 0 :
     *  nge[0] = 1
     *  nge[1] = 2
     *  nge[2] = 4 which is out of its window (0-2)
     *  so sliding[0] = array[2] = 3
     *
     *  for position 1 :
     *  nge[1] = 2
     *  nge[2] = 4 which is out of its window (1-3)
     *  so sliding[1] = array[2] = 3
     *
     *
     *
     */
    private static int[] find(int[] array, int window) {
        int[] sliding = new int[array.length-window+1];
        int[] nge = getNextGreaterElement(array);

        int maxIndex = 0;
        for (int i=0; i< sliding.length; i++){
            if (maxIndex > i){
                maxIndex = i;
            }
            while (nge[maxIndex] < i+window){
                maxIndex = nge[maxIndex];
            }
            sliding[i] = array[maxIndex];
        }
        return sliding;
    }

    private static int[] getNextGreaterElement(int[] array) {
        int[] nge = new int[array.length];
        nge[array.length-1] = array.length;
        var stack = new Stack<Integer>();
        stack.push(array.length-1);
        for (int i=array.length-2; i>=0;i--){
            while (!stack.isEmpty() && array[i] >= array[stack.peek()]) {
                stack.pop();
            }

            if (stack.isEmpty()){
                nge[i] = array.length;
            } else {
                nge[i] = stack.peek();
            }
            stack.push(i);
        }
        return nge;
    }
}
