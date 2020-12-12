package dynamic.category1;

public class StairsPath {

    public static void main(String[] args) {
        System.out.println(StairsPath.dpTabular(5, 3));
    }

    public static int dpTabular(int n, int k){
        int[] dp = new int[n+1];
        dp[0] = 1;

        for (int i=1; i <= n; i++){
            int sum = 0;
            if (i<k){ // if less just plus all previous ways
                for (int t=0;t<i;t++){
                    sum+=dp[t];
                }
            }else {
                for (int j=1; j<=k; j++){
                    sum += dp[i-j];
                }
            }

            dp[i] = sum;
        }
        return dp[n];
    }

    private static int dpMemoization(int n, int k) {
        return dpMemoization(n, k, new int[n+1]);
    }

    private static int dpMemoization(int n, int k, int[] questionBank) {

        if (n <= 0){
            if (n == 0){
                return 1;
            }
            return 0;
        }

        if (questionBank[n] != 0){
            return questionBank[n];
        }

        int sum =0;
        for (int i=1; i<=k; i++){
            sum = sum + recursion(n-i, k);
        }

        questionBank[n] = sum;
        return sum;
    }

    private static int recursion(int n, int k) {

        if (n <= 0){
            if (n == 0){
                return 1;
            }
            return 0;
        }

        int sum =0;
        for (int i=1; i<=k; i++){
            sum = sum + recursion(n-i, k);
        }
        return sum;
    }
}
