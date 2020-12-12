package backtracking;

/**
 * Generate all string of n bits / Print Permutations
 */
public class AllStringsOfNBits {

    public static void binary1(int n, int k, int[] A, String str) {
        if (n < 1) {
            String tempStr = "";
            for (int value : A) {
                tempStr = tempStr.concat(String.valueOf(str.charAt(value)));
            }
            System.out.println(tempStr);
        } else {
            for (int j=0; j<k;j++) {
                A[n - 1] = j;
                binary1(n - 1, k, A, str);
            }
        }
    }

    public static void binary2(int n, int[] A) {
        if (n < 1) {
            for (int value : A) {
                System.out.print(value);
            }
            System.out.println("");
        } else {
            A[n - 1] = 0;
            binary2(n - 1, A);
            A[n - 1] = 1;
            binary2(n - 1, A);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[] A = new int[n];
        binary1(n, 2, A, "ab");
        binary2(n,A);
    }
}
