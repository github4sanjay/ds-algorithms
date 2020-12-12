package backtracking;

public class FriendsPairing {

    /**
     * Input  : n = 3
     * Output : 4
     *
     * Explanation
     * {1}, {2}, {3} : all single
     * {1}, {2, 3} : 2 and 3 paired but 1 is single.
     * {1, 2}, {3} : 1 and 2 are paired but 3 is single.
     * {1, 3}, {2} : 1 and 3 are paired but 2 is single.
     * Note that {1, 2} and {2, 1} are considered same.
     */

    public static void main(String[] args) {
        /**
         * {1}{2}{3}{4}
         * {1}{2}{3,4}
         * {1}{2,3}{4}
         * {1}{2,4}{3}
         * {1,2}{3}{4}
         * {1,2}{3,4}
         * {1,3}{2}{4}
         * {1,3}{2,4}
         * {1,4}{2}{3}
         * {1,4}{2,3}
         */
        int n = 4;
        FriendsPairing.print(n, 1, "", new boolean[n+1]);
    }

    private static void print(int n, int i, String ans, boolean[] used) {
        if (i > n) {
            System.out.println(ans);
            return;
        }

        if (used[i]){
            print(n,i+1, ans, used);
        } else {
            used[i] = true;
            print(n,i+1, ans+"{"+(i)+"}", used);
            for (int j= i+1; j<=n ;j++) {
                if (!used[j]){ // if j not used
                    used[j] = true;
                    print(n, i + 1, ans + "{" + (i) + "," + (j) + "}", used);
                    used[j] = false;
                }
            }
            used[i] = false;
        }
    }
}
