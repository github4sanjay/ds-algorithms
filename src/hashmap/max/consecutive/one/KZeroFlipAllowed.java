package hashmap.max.consecutive.one;

import java.util.HashMap;

/**
 * Find maximum consecutive ones in an array of 0s and 1s, If k flip is allowed.
 *
 * Given an array which only consists of 0s and 1s.
 * Write a code to find the maximum number of consecutive 1s in an array, if we can flip k zeros.
 *
 * For example:
 *
 * Input – {1, 1, 0, 0, 0, 1, 1, 1, 1, 1}, k = 2 (We can flip two zeros)
 *
 * Output: 7
 *
 * In this example, If we can flip at most k (which is 2) zero then the maximum number of consecutive 1s in an array is 7 {1, 1, 1, 1, 1, 1, 1}.
 */
public class KZeroFlipAllowed {

    public static void main(String[] args) {
        System.out.println(KZeroFlipAllowed.find(new int[]{1, 1, 0, 0, 0, 1, 1, 1, 1, 1}, 2)); // 7
    }

    private static int find(int[] array, int k) {
        int i=0, j=-1;
        int maxLength = Integer.MIN_VALUE;
        int zeroCount = 0;
        while (i < array.length){
            if (array[i] == 0){
                zeroCount++;
            }
            while (zeroCount > k){
                j++;
                if (array[j] == 0){
                    zeroCount--;
                }
            }
            maxLength = Math.max(maxLength, i-j);
            i++;
        }
        return maxLength;
    }
}
