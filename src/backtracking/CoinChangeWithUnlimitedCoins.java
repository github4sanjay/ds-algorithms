package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CoinChangeWithUnlimitedCoins {

    public static void main(String[] args) {
        CoinChangeWithUnlimitedCoins.find(new int[]{2,3,5,6,7}, 12);
    }

    private static void find(int[] coins, int sum) {
        find(coins, sum, new ArrayList<>(), 0);
    }

    private static void find(int[] coins, int sum, List<Integer> coinChosen, int currentCoinIndex) {

        if (currentCoinIndex == coins.length){
            if (sum == 0){
                System.out.println(coinChosen);
            }
            return;
        }

        int currentCoin = coins[currentCoinIndex];

        for (int i=sum/currentCoin; i >0; i--){ // important 12/2 = 6 so 2 can be taken six times
            for (int j=0; i>j;j++){
                coinChosen.add(currentCoin);
            }

            find(coins, sum-currentCoin*i, coinChosen, currentCoinIndex+1);

            for (int j=0; i>j;j++){
                coinChosen.remove(coinChosen.size()-1);
            }

        }

        find(coins, sum, coinChosen, currentCoinIndex+1);
    }
}
