package hashmap.subarray;

import java.util.HashMap;

/**
 * Given an unsorted array of integers, find the number of subarrays having sum exactly equal to a given number k.
 *
 * Examples:
 *
 * Input : arr[] = {10, 2, -2, -20, 10},
 *         k = -10
 * Output : 3
 * Subarrays: arr[0...3], arr[1...4], arr[3..4]
 * have sum exactly equal to -10.
 *
 * Input : arr[] = {9, 4, 20, 3, 10, 5},
 *             k = 33
 * Output : 2
 * Subarrays : arr[0...2], arr[2...4] have sum
 * exactly equal to 33.
 */
public class CountHavingSumEqualsToK {

    public static void main(String[] args) {
        System.out.println(CountHavingSumEqualsToK.find(new int[]{10, 2, -2, -20, 10}, -10));
        System.out.println(CountHavingSumEqualsToK.find(new int[]{9, 4, 20, 3, 10, 5}, 33));
        System.out.println(CountHavingSumEqualsToK.find(new int[]{1, 1, 1}, 2));
        System.out.println(CountHavingSumEqualsToK.find(new int[]{3, 9,-2,4,1, -7, 2,6,-5,8,-3,-7,6,2,1}, 5)); // 7
    }

    private static int find(int[] array, int sum) {
        int count = 0;
        var map = new HashMap<Integer, Integer>(); // sum and frequency
        int currentSum = 0;
        map.put(0, 1);
        for (int i=0; i< array.length; i++){
            currentSum = currentSum + array[i];
            if (map.containsKey(currentSum-sum)){
                var frequency = map.get(currentSum-sum);
                count =  count + frequency;
            }
            map.put(currentSum, map.getOrDefault(currentSum, 0)+1);
        }
        return count;
    }
}
