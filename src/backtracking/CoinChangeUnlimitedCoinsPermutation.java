package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CoinChangeUnlimitedCoinsPermutation {

    public static void main(String[] args) {
        CoinChangeUnlimitedCoinsPermutation.find(new int[]{2,3,5}, 7);
    }

    private static void find(int[] coins, int sum) {
        find(coins, sum, new ArrayList<>());
    }

    private static void find(int[] coins, int sum, List<Integer> coinChooses) {
        if (sum <= 0){
            if (sum ==0){
                System.out.println(coinChooses);
            }
            return;
        }

        for (int i=0; i< coins.length; i++){
            coinChooses.add(coins[i]);
            find(coins, sum-coins[i], coinChooses);
            coinChooses.remove(coinChooses.size()-1);
        }
    }
}
