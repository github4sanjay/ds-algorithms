package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CoinChange {

    public static void main(String[] args) {
        CoinChange.find(new int[]{2,3,5,7}, 12);
    }

    private static void find(int[] coins, int sum) {
        find(coins, sum, new ArrayList<>(), 0);
    }

    private static void find(int[] coins, int sum, List<Integer> coinChosen, int currentCoinIndex) {

        if (currentCoinIndex == coins.length){
            if (sum==0){
                System.out.println(coinChosen);
            }
            return;
        }

        find(coins, sum, coinChosen, currentCoinIndex+1);
        int currentCoin = coins[currentCoinIndex];
        coinChosen.add(currentCoin);
        find(coins, sum-currentCoin, coinChosen, currentCoinIndex+1);
        coinChosen.remove(coinChosen.size()-1);
    }
}
