package sorting;

import java.util.Arrays;

/**
 * stable count sort means does not change the order of equal weight elements
 */
public class CountSort {
    public static int[] sort(int[] A){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int value : A) {
            if (value <= min) {
                min = value;
            }
            if (value >= max){
                max = value;
            }
        }

        int range = max - min + 1;
        int[] tempArray = new int[range];
        for (int i=0; i < A.length; i++) {
            tempArray[A[i]-min]++;
        }
        int sum = -1;
        for (int i=0; i < tempArray.length; i++) {
            sum = sum + tempArray[i];
           tempArray[i] = sum;
        }
        int[] finalArray = new int[A.length];
        for (int i=A.length-1; i >= 0; i--) {
            finalArray[tempArray[A[i]-min]] = A[i];
            tempArray[A[i]-min]--;
        }
        return finalArray;
    }

    /**
     * min = 0, array length = 10 as digits
     */
    public static void sort(int[] A, int exp){

        int[] tempArray = new int[10];
        for (int value : A) {
            tempArray[value / exp % 10]++;
        }
        int sum = -1;
        for (int i=0; i < tempArray.length; i++) {
            sum = sum + tempArray[i];
            tempArray[i] = sum;
        }
        int[] finalArray = new int[A.length];
        for (int i=A.length -1; i >= 0; i--) {
            finalArray[tempArray[A[i]/ exp % 10]] = A[i];
            tempArray[A[i]/ exp % 10]--;
        }
        System.arraycopy(finalArray, 0, A, 0, finalArray.length);
    }

    public static void sort(String[] A, int div, int mod, int range){

        int[] tempArray = new int[range];
        for (int i=0; i< A.length; i++) {
            tempArray[Integer.parseInt(A[i], 10) /div % mod]++; // starts with 0 so can be assumed octal so give base 10
        }

        for (int i=1; i< tempArray.length; i++) {
            tempArray[i] += tempArray[i-1];
        }
        String[] finalArray = new String[A.length];
        for (int i=A.length -1; i >= 0; i--) {
            int pos = tempArray[(Integer.parseInt(A[i], 10) /div % mod)] -1;
            finalArray[pos] = A[i];
            tempArray[Integer.parseInt(A[i], 10) /div % mod]--;
        }
        System.arraycopy(finalArray, 0, A, 0, finalArray.length);
    }

    public static void main(String[] args) {
        int[] arr = {9,6,3,5,3,4,3,9,6,4,6,5,8,9,9};
        System.out.println(Arrays.toString(CountSort.sort(arr)));

        int[] arr1 = { -5, -10, 0, -3, 8, 5, -1, 10 };
        System.out.println(Arrays.toString( CountSort.sort(arr1)));

        int[] arr2 = {};
        System.out.println(Arrays.toString(CountSort.sort(arr2)));

        int[] arr3 = {64, 25, 12, 22, 11};
        System.out.println(Arrays.toString(CountSort.sort(arr3)));

        int[] arr4 = {4,31, 143, 1, 2};
        System.out.println(Arrays.toString(CountSort.sort(arr4)));
    }
}
