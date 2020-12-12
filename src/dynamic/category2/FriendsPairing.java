package dynamic.category2;

/**
 * Given n friends, each one can remain single or can be paired up with some other friend.
 * Each friend can be paired only once. Find out the total number of ways in which friends can remain single or can be paired up.
 *
 * Examples :
 *
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
public class FriendsPairing {

    public static void main(String[] args) {
        System.out.println(FriendsPairing.count(3)); // 26
    }

    // combination f(n) = f(n-1) + (n-1) f(n-2)
    private static int count(int n) {
        int[] dp = new int[n+1];
        dp[0]= 1;
        dp[1] = 1;

        for (int i=2;i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2]*(i-1);
        }
        return dp[n];
    }

    // permutation f(n) = n * f(n-1) + nc2 * f(n-2)
    private static int countPermutation(int n) {
        int[] dp = new int[n+1];
        dp[0]= 1;
        dp[1] = 1;

        for (int i=2;i <= n; i++){
            dp[i] = i*dp[i-1] + dp[i-2]*(i*(i-1))/2;
        }
        return dp[n];
    }

    // brute force
    private static int countBruteForce(int n) {
        if (n < 0 ) return 0;
        if (n==1 || n==0) return 1;
        return countBruteForce(n-1)+countBruteForce(n-2)*(n-1);
    }
}
