package search;

import java.util.Arrays;

/**
 * Given an array arr[] of N integers and an integer X, the task is to find three integers in arr[] such that the sum is closest to X.
 * Examples:
 *
 * Input: arr[] = {-1, 2, 1, -4}, X = 1
 * Output: 2
 * Explanation:
 * Sums of triplets:
 * (-1) + 2 + 1 = 2
 * (-1) + 2 + (-4) = -3
 * 2 + 1 + (-4) = -1
 * 2 is closest to 1.
 *
 * Input: arr[] = {1, 2, 3, 4, -5}, X = 10
 * Output: 9
 * Explanation:
 * Sums of triplets:
 * 1 + 2 + 3 = 6
 * 2 + 3 + 4 = 9
 * 1 + 3 + 4 = 7
 * ...
 * 9 is closest to 10.
 *
 */
public class ThreeElementSumClosestToK {

    public static void main(String[] args) {
        System.out.println(bruteForce(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(bruteForce(new int[]{1, 2, 3, 4, -5}, 10));
        System.out.println(withSorting(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(withSorting(new int[]{1, 2, 3, 4, -5}, 10));
    }

    private static Pair withSorting(int[] array, int k) {
        Arrays.sort(array);
        var pair = new Pair();
        int minSum = Integer.MAX_VALUE;
        for (int m=0; m< array.length; m++){
            int i=m+1, j=array.length-1;
            while (i < j){
                int sum = array[m] + array[j] + array[i];
                if (Math.abs(sum-k) < Math.abs(minSum-k)){
                    minSum = sum;
                    pair.data1 = array[i];
                    pair.data2 = array[j];
                    pair.data3 = array[m];
                }
                if (sum > k){
                    j--;
                } else if (sum < k){
                    i++;
                }
            }
        }

        return pair;
    }

    private static Pair bruteForce(int[] array, int k) {
        var pair = new Pair();
        int minSum = Integer.MAX_VALUE;
        for (int i=0; i< array.length; i++){
            for (int j=i+1;j<array.length;j++){
                for (int m=j+1; m< array.length; m++){
                    int sum = array[j] + array[i] + array[m];
                    if (Math.abs(sum-k) < Math.abs(k-minSum)){
                        minSum = sum;
                        pair.data1 = array[i];
                        pair.data2 = array[j];
                        pair.data3 = array[m];
                    }
                }
            }
        }
        return pair;
    }

    private static class Pair {
        Integer data1;
        Integer data2;
        Integer data3;

        @Override
        public String toString() {
            return "Pair{" +
                    "data1=" + data1 +
                    ", data2=" + data2 +
                    ", data3=" + data3 +
                    '}';
        }
    }
}
