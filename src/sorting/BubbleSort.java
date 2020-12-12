package sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void sort(int[] A){
        for (int i=1; i< A.length; i++){
            for (int j=0; j< A.length -i; j++){
                if (A[j] > A[j+1]){
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4, 6, 7, 5, 8, 9};
        BubbleSort.sort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = {2};
        BubbleSort.sort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {};
        BubbleSort.sort(arr2);
        System.out.println(Arrays.toString(arr2));


        int[] arr3 = {1,2,1,1};
        BubbleSort.sort(arr3);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = {4, 31, 32, 1, 2};
        BubbleSort.sort(arr4);
        System.out.println(Arrays.toString(arr4));
    }
}
