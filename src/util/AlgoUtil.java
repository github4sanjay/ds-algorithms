package util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class AlgoUtil {
    public static void print(char[][] chars){
        for (int i=0; i< chars.length; i++) {
            System.out.println(Arrays.toString(chars[i]));
        }
    }

    public static <T> void print(List<List<T>> lists){
        for (List<T> list : lists) {
            System.out.println(list);
        }
    }

    public static <T> boolean verifyAllEqual(List<T> list) {
        return new HashSet<T>(list).size() <= 1;
    }

    public static String swap(int i, int j, String number) {
        char charI = number.charAt(i);
        char charJ = number.charAt(j);

        String left = number.substring(0, i);
        String right = number.substring(j+1);
        String middle = number.substring(i+1, j);
        return left+charJ+middle+charI+right;
    }

    public static void print(int[][] placed) {
        for (int[] ints : placed) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static void print(boolean[][] placed) {
        for (boolean[] ints : placed) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
