package dynamic.category3;

/**
 * 1. You are given a number n, representing the number of days.
 * 2. You are given n numbers, where ith number represents price of stock on ith day.
 * 3. You are required to print the maximum profit you can make if you are allowed infinite transactions, but have to cooldown for 1 day after 1 transaction
 * i.e. you cannot buy on the next day after you sell, you have to cooldown for a day at-least before buying again.
 * Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
 *
 *  12 -> n
 *  {10, 15, 17, 20, 16, 18, 22, 20, 22, 20, 23, 25}
 * output : 19
 */
public class BuySellStocksInfiniteTxnAllowedWithCoolDown {

    public static void main(String[] args) {
        System.out.println(BuySellStocksInfiniteTxnAllowedWithCoolDown.findAlt(
                new int[]{10, 15, 17, 20, 16, 18, 22, 20, 22, 20, 23, 25})); // 19
    }

    private static int findAlt(int[] stockPrices) {
        int bsp = -stockPrices[0];
        int ssp = 0;
        int csp = 0;
        for (int i=1; i< stockPrices.length; i++){
            int temp = bsp;
            bsp = Math.max(bsp, csp - stockPrices[i]);
            csp = Math.max(csp, ssp);
            ssp = Math.max(ssp, stockPrices[i] + temp);
        }

        return ssp;
    }
}
