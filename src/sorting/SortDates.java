package sorting;

import java.util.Arrays;

public class SortDates {

    public static void sort(String[] arr){
        CountSort.sort(arr, 1000000, 100, 32); //days
        CountSort.sort(arr, 10000, 100, 13); // month
        CountSort.sort(arr, 1, 10000, 2501); // years
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"20012014", "25032010", "03122000", "18112001", "19042015", "09072005"};
        SortDates.sort(arr);
        System.out.println(Arrays.toString(arr)); // [03122000, 18112001, 09072005, 25032010, 20012014, 19042015]
    }
}
