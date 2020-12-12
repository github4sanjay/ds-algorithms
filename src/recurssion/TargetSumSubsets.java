package recurssion;

import java.util.ArrayList;

public class TargetSumSubsets {
    public static void main(String[] args) {

        TargetSumSubsets.find(new int[]{10, 20, 30, 40, 50}, 70);
    }

    private static void find(int[] arr, int sum){
        find(arr, sum, 0, "", 0);
    }

    private static void find(int[] arr, int targetSum, int sum, String set, int idx) {
        if (sum < 0 || idx == arr.length){
            if (sum == targetSum){
                System.out.println(set);
            }
            return;
        }


        find(arr, targetSum, sum, set, idx+1);
        find(arr, targetSum, sum+arr[idx], set+arr[idx]+",", idx+1);
    }
}
