package com.github4sanjay.dsalgo.stack;

import com.github4sanjay.dsalgo.util.Pair;
import java.util.LinkedList;

/*
   Online Stock Span
    Medium

    1: Complete the next function in class StockSpanner which collects daily price quotes for some stock, and returns the span of that stock's price for the current day.
    2: The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.

    For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], then the stock spans would be [1, 1, 1, 2, 1, 4, 6].

    Constraints
    Calls to StockSpanner.next(int price) will have 1 <= price <= 10^5.

    Format
    Input
    Input is managed for you

    Output
    Output is managed for you

    Example
    Sample Input

    100
    80
    60
    70
    60
    75
    85

    Sample Output
    1
    1
    1
    2
    1
    4
    6
*/
public class OnlineStockSpan {

  public static class StockSpanner {

    private final LinkedList<Pair> stack = new LinkedList<>();
    private int index = -1;

    public int next(int price) {
      index++;
      if (stack.isEmpty()) {
        stack.push(new Pair(index, price));
        return 1;
      } else {
        while (!stack.isEmpty() && stack.peek().getData2() < price) {
          stack.pop();
        }
        if (stack.isEmpty()) return 1;
        var peek = stack.peek();
        stack.push(new Pair(index, price));
        return index - peek.getData1();
      }
    }
  }
}
