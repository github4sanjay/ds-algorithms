package search;

import java.util.Arrays;
import java.util.HashSet;

/**
 * You are given a list of n-1 integers and these integers are in the range of 1 to n.
 * There are no duplicates in the list. One of the integers is missing in the list. Write an efficient code to find the missing integer.
 * Example:
 *
 * Input: arr[] = {1, 2, 4, 6, 3, 7, 8}
 * Output: 5
 * Explanation: The missing number from 1 to 8 is 5
 *
 * Input: arr[] = {1, 2, 3, 5}
 * Output: 4
 * Explanation: The missing number from 1 to 5 is 4
 */
public class FindMissingNumberInN {

    public static void main(String[] args) {
        System.out.println(bruteForce(new int[]{1, 2, 4, 6, 3, 7, 8}));
        System.out.println(withHashTable(new int[]{1, 2, 4, 6, 3, 7, 8}));
        System.out.println(withSorting(new int[]{1, 2, 4, 6, 3, 7, 8}));
        System.out.println(withSum(new int[]{1, 2, 4, 6, 3, 7, 8}));
    }

    private static int withSum(int[] array) {
        int sum = ((array.length+2)*(array.length+1))/2;
        for (int i : array) {
            sum = sum - i;
        }
        return sum;
    }

    private static int withSorting(int[] array) {
        Arrays.sort(array);
        for (int j=1;j<array.length+1;j++){
            if (array[j-1] != j){
                return j;
            }
        }
        throw new RuntimeException("All elements are present");
    }

    private static int withHashTable(int[] array) {
        var set = new HashSet<Integer>();
        for (int k : array) {
            set.add(k);
        }
        for (int j=1;j<array.length+1;j++){
            if (!set.contains(j)){
                return j;
            }
        }
        throw new RuntimeException("All elements are present");
    }

    private static int bruteForce(int[] array) {
        for (int i=0; i< array.length; i++){
            var lookFor = array[i]+1;
            var found = false;
            for (int j=i;j<array.length;j++){
                if (array[j] == lookFor){
                    found = true;
                    break;
                }
            }
            if (!found){
                return lookFor;
            }
        }
        throw new RuntimeException("All elements are present");
    }
}
