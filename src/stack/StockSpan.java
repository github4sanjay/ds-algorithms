package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate span of stock’s price for all n days.
 * The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than or equal to its price on the given day.
 * For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85},
 * then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
 */
public class StockSpan {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(StockSpan.find(new int[]{100, 80, 60, 70, 60, 75, 85}))); // [1, 1, 1, 2, 1, 4, 6]
        System.out.println(Arrays.toString(StockSpan.find(new int[]{ 10, 4, 5, 90, 120, 80 }))); // [1, 1, 2, 4, 5, 1]
        System.out.println(Arrays.toString(StockSpan.find(new int[]{ 2, 5, 9, 3, 1 ,12, 6, 8, 7 }))); // [1, 2, 3, 1, 1, 6, 1, 2, 1]
    }

    /**
     * Basically need to find next greater element on left from current element
     *
     */
    public static int[] find(int[] prices) {
        int[] span = new int[prices.length];
        span[0] = 1;
        var stack = new Stack<Integer>();
        stack.push(0);
        for (int i=1;i<span.length;i++){
            while (!stack.isEmpty() && prices[i] >= prices[stack.peek()]){
                stack.pop();
            }
            if (stack.isEmpty()){
                span[i] = i + 1;
            } else {
                span[i] = i - stack.peek();
            }
            stack.push(i);
        }
        return span;
    }
}
