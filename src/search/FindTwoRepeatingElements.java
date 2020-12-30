package search;

import java.util.HashSet;
import java.util.Hashtable;

/**
 * You are given an array of n+2 elements. All elements of the array are in range 1 to n.
 * And all elements occur once except two numbers which occur twice. Find the two repeating numbers.
 * For example, array = {4, 2, 4, 5, 2, 3, 1} and n = 5
 *
 * The above array has n + 2 = 7 elements with all elements occurring once except 2 and 4 which occur twice. So the output should be 4 2.
 */
public class FindTwoRepeatingElements {

    public static void main(String[] args) {
        System.out.println(bruteForce(new int[]{4, 2, 4, 5, 2, 3, 1}));
        System.out.println(withHashTable(new int[]{4, 2, 4, 5, 2, 3, 1}));
    }

    private static Pair withHashTable(int[] array) {
        var table = new HashSet<Integer>();
        var pair = new Pair();
        for (int j : array) {
            if (table.contains(j)) {
                if (pair.data1 == null) {
                    pair.data1 = j;
                } else if (pair.data2 == null) {
                    pair.data2 = j;
                } else {
                    return pair;
                }
            } else {
                table.add(j);
            }
        }
        return pair;
    }

    // O(n^2)
    private static Pair bruteForce(int[] array) {
        var pair = new Pair();
        for (int i=0; i< array.length; i++){
            for (int j=i;j<array.length;j++){
                if (array[j] == array[i]){
                    if (pair.data1 == null){
                        pair.data1 = array[j];
                    } else if (pair.data2 == null){
                        pair.data2 = array[j];
                    } else {
                        return pair;
                    }
                    break;
                }
            }
        }
        return pair;
    }

    private static class Pair {
        Integer data1;
        Integer data2;

        @Override
        public String toString() {
            return "Pair{" +
                    "data1=" + data1 +
                    ", data2=" + data2 +
                    '}';
        }
    }

}
