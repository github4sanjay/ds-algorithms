package search;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Given an array of positive integers. All numbers occur even number of times except one number which occurs odd number of times. Find the number in O(n) time & constant space.
 * Examples :
 *
 * Input : arr = {1, 2, 3, 2, 3, 1, 3}
 * Output : 3
 *
 * Input : arr = {5, 7, 2, 7, 5, 2, 5}
 * Output : 5
 */
public class FindNumberOccurringOddNumberOfTimes {

    public static void main(String[] args) {
        System.out.println(withXOR(new int[]{1, 2, 3, 2, 3, 1, 3}));
        System.out.println(withXOR(new int[]{5, 7, 2, 7, 5, 2, 5}));
    }

    /**
     * Since A XOR A = 0
     */
    private static int withXOR(int[] array) {
        int xor = 0;
        for (int item : array){
            xor = xor ^ item;
        }
        return xor;
    }

}
