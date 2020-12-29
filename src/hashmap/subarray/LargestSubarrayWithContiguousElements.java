package hashmap.subarray;

import java.util.HashSet;

/**
 * Given an array of distinct integers, find length of the longest subarray which contains numbers that can be arranged in a continuous sequence.
 * Examples:
 *
 * Input:  arr[] = {10, 12, 11};
 * Output: Length of the longest contiguous subarray is 3
 *
 * Input:  arr[] = {14, 12, 11, 20};
 * Output: Length of the longest contiguous subarray is 2
 *
 * Input:  arr[] = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
 * Output: Length of the longest contiguous subarray is 5
 */
public class LargestSubarrayWithContiguousElements {

    public static void main(String[] args) {
        System.out.println(LargestSubarrayWithContiguousElements.find(new int[]{1, 56, 58, 57, 90, 92, 94, 93, 91, 45}));
        System.out.println(LargestSubarrayWithContiguousElements.find(new int[]{14, 12, 11, 20}));
        System.out.println(LargestSubarrayWithContiguousElements.find(new int[]{10, 12, 11}));
        System.out.println(LargestSubarrayWithContiguousElements.find(new int[]{10}));
        System.out.println(LargestSubarrayWithContiguousElements.find(new int[]{1,2,2,2,5})); // 2 as duplicates
    }

    private static int find(int[] array) {
        int maxLength = Integer.MIN_VALUE;
        for (int i=0; i< array.length; i++){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            var set = new HashSet<Integer>();
            for (int j=i; j<array.length;j++){
                if (set.contains(array[j])){
                    break; // duplicate found
                }
                min = Math.min(min, array[j]);
                max = Math.max(max, array[j]);

                if (max - min >= array.length) // gap is huge cannot be so many elements in array possible
                    break;

                if (max -min == j - i){
                    maxLength = Math.max(maxLength, j-i+1);
                }
                set.add(array[j]);
            }
        }
        return maxLength;
    }
}
