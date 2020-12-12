package dynamic.category2;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of positive numbers, find the maximum sum of a subsequence with the constraint that no 2 numbers
 * in the sequence should be adjacent in the array. So 3 2 7 10 should return 13 (sum of 3 and 10) or 3 2 5 10 7
 * should return 15 (sum of 3, 5 and 7).Answer the question in most efficient way.
 *
 * Examples :
 *
 * Input : arr[] = {5, 5, 10, 100, 10, 5}
 * Output : 110
 *
 * Input : arr[] = {1, 2, 3}
 * Output : 4
 *
 * Input : arr[] = {1, 20, 3}
 * Output : 20
 */
public class MaxSumNonAdjacentElements {

    public static void main(String[] args) {
        int arr[] = new int[]{5, 10, 10, 100, 10, 6}; // 116
        System.out.println(MaxSumNonAdjacentElements.findMaxSumDP(arr));
    }


    private static int findMaxSumDP(int[] arr) {

        int include = 0;
        int exclude = 0;
        for (int i=0; i< arr.length; i++){
            int tempInclude = include;
            include = arr[i] + exclude;
            exclude = Math.max(tempInclude, exclude);
        }

        return Math.max(include, exclude);
    }


    public static class Answer{
        List<Integer> set = new ArrayList<>();
        int max = Integer.MIN_VALUE;
    }

    private static int findMaxSumBruteForce(int[] arr) {
        var answer = new Answer();
        findMaxSum(arr, 0, answer, false);
        return answer.max;
    }


    // brute force 2^n time complexity
    private static void findMaxSum(int[] arr, int index, Answer answer, boolean taken) {

        if (index == arr.length){
            int sum = 0;
            for (int item : answer.set){
                sum+= item;
            }
            if (sum > answer.max){
                answer.max = sum;
            }
            return;
        }

        if (taken){
            findMaxSum(arr, index+1, answer, false); // if taken then only option not take next
        } else { // if not taken then can take and cannot take both available
            findMaxSum(arr, index+1, answer, false);
            answer.set.add(arr[index]);
            findMaxSum(arr, index+1, answer, true);
            answer.set.remove(answer.set.size()-1);
        }
    }
}
