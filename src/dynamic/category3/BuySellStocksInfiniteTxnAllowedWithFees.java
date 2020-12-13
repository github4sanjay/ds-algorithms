package dynamic.category3;

/**
 * 1. You are given a number n, representing the number of days.
 * 2. You are given n numbers, where ith number represents price of stock on ith day.
 * 3. You are give a number fee, representing the transaction fee for every transaction.
 * 4. You are required to print the maximum profit you can make if you are allowed infinite transactions, but has to pay "fee" for every closed transaction.
 * Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell)
 * before opening another transaction (another buy).
 *
 *  12 -> n
 *  {10, 15, 17, 20, 16, 18, 22, 20, 22, 20, 23, 25}
 *  3 fees
 * output : 13
 */
public class BuySellStocksInfiniteTxnAllowedWithFees {

    public static void main(String[] args) {
        System.out.println(BuySellStocksInfiniteTxnAllowedWithFees.findAlt(
                new int[]{10, 15, 17, 20, 16, 18, 22, 20, 22, 20, 23, 25, 3},
                3
                )); // 13
    }

    private static int findAlt(int[] stockPrices, int fee) {
        int bsp = -stockPrices[0]; // buy state profit
        int ssp = 0; // sell state profit

        for (int i=1; i< stockPrices.length; i++){
            int temp = bsp;
            bsp = Math.max(bsp, ssp - stockPrices[i]);
            ssp = Math.max(ssp, stockPrices[i] + temp - fee);
        }

        return ssp;
    }
}
