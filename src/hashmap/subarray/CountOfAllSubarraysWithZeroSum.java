package hashmap.subarray;

import hashmap.structure.HashMap;

/**
 *1. You are given an array(arr) of integers.
 * 2. You have to find the count of all subarrays with sum 0.
 *
 * 15 -2 2 -8 1 7 10 23
 *
 * Sample Output
 * 3
 */
public class CountOfAllSubarraysWithZeroSum {

    public static void main(String[] args) {
        System.out.println(CountOfAllSubarraysWithZeroSum.find(new int[]{15, -2, 2, -8, 1, 7, 10, 23})); // 3
        System.out.println(CountOfAllSubarraysWithZeroSum.find(new int[]{2, 8, -3, -5, 2, -4, 6, 1, 2, 1, -3, 4})); // 6
    }

    private static int find(int[] array) {
        var map = new HashMap<Integer, Integer>(); // sum vs frequency
        int sum = 0;
        map.put(0, 1);
        int count = 0;
        for (int i=0; i< array.length; i++){
            sum = sum + array[i];
            if (map.containsKey(sum)){
                var frequency = map.get(sum);
                count =  count + frequency;
                map.put(sum, frequency+1);
            } else {
                map.put(sum, 1);
            }
        }
        return count;
    }
}
