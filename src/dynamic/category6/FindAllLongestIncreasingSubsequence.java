package dynamic.category6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Construction of Longest Increasing Subsequence(LIS) and printing LIS sequence
 *
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence
 * of a given sequence such that all elements of the subsequence are sorted in increasing order.
 * For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 *
 * Input:  [10, 22, 9, 33, 21, 50, 41, 60, 80]
 * Output: [10, 22, 33, 50, 60, 80]
 *         OR
 *         [10 22 33 41 60 80] or any other LIS of same length.
 */
public class FindAllLongestIncreasingSubsequence {

    public static void main(String[] args) {
        System.out.println(FindAllLongestIncreasingSubsequence.find(new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80}));
    }

    /**
     *
     * Find LIS solution with dynamic programming and then create queue to do breadth first traversing
     * First pop and then look for element in dp with length-1 of current element and also should be less than current value
     * and push those elements in the queue. when popped length is 1, you get the list.
     *
     * @param arr array to find longest increasing subsequences
     * @return List of longest increasing subsequences
     */
    public static List<List<Integer>> find(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i=1; i< arr.length; i++){
            int localMax = Integer.MIN_VALUE;
            for (int j=0; j<i; j++){
                if (arr[i] > arr[j]){
                    localMax = Math.max(localMax, dp[j]);
                }
            }
            if (localMax == Integer.MIN_VALUE){
                dp[i] = 1;
            } else {
                dp[i] = localMax + 1;
            }
            max = Math.max(max, dp[i]);
            if (dp[i] >= max){
                maxIndex = i;
            }
        }

        var queue = new LinkedList<Node>();
        var pathSoFar = new ArrayList<Integer>();
        pathSoFar.add(arr[maxIndex]);
        queue.add(new Node(maxIndex, arr[maxIndex], dp[maxIndex], pathSoFar));
        var list = new ArrayList<List<Integer>>();

        while (!queue.isEmpty()){
            var node = queue.pop();
            if (node.length == 1){
                list.add(node.pathSoFar);
            }
            for (int i=0; i < node.index; i++){
                if (dp[i] == node.length-1 && arr[i] <= node.value){
                    var pathSoFarTemp = new ArrayList<>(node.pathSoFar);
                    pathSoFarTemp.add(arr[i]);
                    queue.add(new Node(i, arr[i], dp[i], pathSoFarTemp));
                }
            }
        }
        return list;
    }

    private static class Node {
        int index;
        int value;
        int length;
        List<Integer> pathSoFar;

        public Node(int index, int value, int length, List<Integer> pathSoFar) {
            this.index = index;
            this.value = value;
            this.length = length;
            this.pathSoFar = pathSoFar;
        }
    }

}
