package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CoinChangePermutation {

    public static void main(String[] args) {
        // CoinChangePermutation.find(new int[]{2,3,5,7, 6}, 12);
        CoinChangePermutation.find(new int[]{1,2,3}, 4);
    }

    private static void find(int[] coins, int sum) {
        find(coins, sum, new ArrayList<>(), new HashSet<>());
    }

    private static void find(int[] coins, int sum, List<Integer> coinChooses, Set<Integer> coinTaken) {
        if (sum <= 0){
            if (sum ==0){
                System.out.println(coinChooses);
            }
            return;
        }

        for (int i=0; i< coins.length; i++){
            if (!coinTaken.contains(coins[i])){ // not require this condition if unlimited coins
                coinChooses.add(coins[i]);
                coinTaken.add(coins[i]);
                find(coins, sum-coins[i], coinChooses, coinTaken);
                coinChooses.remove(coinChooses.size()-1);
                coinTaken.remove(coins[i]);
            }
        }
    }
}
