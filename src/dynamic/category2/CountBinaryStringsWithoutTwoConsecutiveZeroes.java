package dynamic.category2;

/**
 * 1. You are given a number n.
 * 2. You are required to print the number of binary strings of length n with no consecutive 0's.
 *
 * 6 -> 21
 */
public class CountBinaryStringsWithoutTwoConsecutiveZeroes {

    public static void main(String[] args) {
        System.out.println(CountBinaryStringsWithoutTwoConsecutiveZeroes.count(6));
    }

    public static int count(int n) {
        int countEndWithZero = 1; // count of length 1 end with 0
        int countEndWithOne = 1;  // count of length 1 end with 1
        for (int i=2; i<= n;i++){
            int temp = countEndWithOne;
            countEndWithOne = countEndWithOne + countEndWithZero;
            countEndWithZero = temp;
        }
        return countEndWithOne+countEndWithZero;
    }
}
