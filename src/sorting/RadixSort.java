package sorting;

import java.util.Arrays;

/**
 * stable count sort means does not change the order of equal weight elements
 */
public class RadixSort {

    public static void sort(int[] A){
        int max = Integer.MIN_VALUE;
        for (int value : A) {
            if (value >= max){
                max = value;
            }
        }

        int exp = 1;
        while (exp <= max){
           CountSort.sort(A, exp);
           exp = exp * 10;
        }
    }

    public static void main(String[] args) {

        int[] arr3 = {64434, 23435, 312, 22, 11};
        RadixSort.sort(arr3);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = {4,31, 143, 1, 2};
        RadixSort.sort(arr4);
        System.out.println(Arrays.toString(arr4));
    }
}
