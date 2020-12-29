package hashmap.subarray;

import hashmap.structure.HashMap;

/**
 * 1. You are given an array(arr) of integers.
 * 2. You have to find the length of the largest subarray with sum 0.
 *
 * Sample Input
 *
 * 8
 * 15 -2 2 -8 1 7 10 23
 *
 * Sample Output
 * 5
 */
public class LargestSubarrayWithZeroSum {

    public static void main(String[] args) {
        System.out.println(LargestSubarrayWithZeroSum.find(new int[]{15, -2, 2, -8, 1, 7, 10, 23})); // 5
        System.out.println(LargestSubarrayWithZeroSum.find(new int[]{2, 8, -3, -5, 2, -4, 6, 1, 2, 1, -3, 4})); // 8
    }

    private static int find(int[] array) {
        var map = new HashMap<Integer, Integer>(); // sum vs index
        int sum = 0;
        map.put(0, -1);
        int maxLength = Integer.MIN_VALUE;
        for (int i=0; i< array.length; i++){
            sum = sum + array[i];
            if (map.containsKey(sum)){
                maxLength = Math.max(maxLength, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLength;
    }
}
