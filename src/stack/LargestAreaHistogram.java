package stack;

import java.util.Stack;

/**
 * Largest Rectangular Area in a Histogram
 *
 * Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of contiguous bars.
 * For simplicity, assume that all bars have same width and the width is 1 unit.
 * For example, consider the following histogram with 7 bars of heights {6, 2, 5, 4, 5, 1, 6}.
 * The largest possible rectangle possible is 12 (see the below figure, the max area rectangle is highlighted in red)
 *
 *
 *      |  6                            6
 *   6  |''''|      5          5      |''''|
 *   5  |    |    |''''| 4  |''''|    |    |
 *   4  |    |    |    |''''|    |    |    |
 *   3  |    |  2 |    |    |    |  1 |    |
 *   2  |    |''''|    |    |    |____|    |
 *   1  |____|____|____|____|____|____|____|__________________
 *                  4*3=12
 *                |_________|
 *
 */
public class LargestAreaHistogram {

    public static void main(String[] args) {
        System.out.println(LargestAreaHistogram.find(new int[]{6, 2, 5, 4, 5, 1, 6}));
    }

    /**
     *
     *
     *      |  6                            6
     *   6  |''''|      5          5      |''''|
     *   5  |    |    |''''| 4  |''''|    |    |
     *   4  |    |    |    |''''|    |    |    |
     *   3  |    |  2 |    |    |    |  1 |    |
     *   2  |    |''''|    |    |    |____|    |
     *   1  |____|____|____|____|____|____|____|__________________
     *     -1<----for 2--------------->5
     *              2*(5-(-1)-1)=10
     *
     *
     *      |  6                            6
     *   6  |''''|      5          5      |''''|
     *   5  |    |    |''''| 4  |''''|    |    |
     *   4  |    |    |    |''''|    |    |    |
     *   3  |    |  2 |    |    |    |  1 |    |
     *   2  |    |''''|    |    |    |____|    |
     *   1  |____|____|____|____|____|____|____|__________________
     *             1<----for 4-------->5
     *                 4*(5-1-1)=12
     *
     *  So basically we need to find next smaller element on left and right for each element.
     */
    public static int find(int[] bars) {
        int[] nseR = getNextSmallerElementRight(bars);
        int[] nseL = getNextSmallerElementLeft(bars);
        int maxArea = Integer.MIN_VALUE;
        for (int i=0; i< bars.length; i++){
            int area = bars[i] * (nseR[i]-nseL[i]-1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    private static int[] getNextSmallerElementLeft(int[] bars) {
        int[] nse = new int[bars.length];
        nse[0] = -1;
        var stack = new Stack<Integer>();
        stack.push(0);
        for (int i=1; i< nse.length; i++){
            while (!stack.isEmpty() && bars[i] <= bars[stack.peek()]) {
                stack.pop();
            }

            if (stack.isEmpty()){
                nse[i] = -1; // for better calculation
            } else {
                nse[i] = stack.peek();
            }

            stack.push(i);
        }
        return nse;
    }

    private static int[] getNextSmallerElementRight(int[] bars) {
        int[] nse = new int[bars.length];
        nse[nse.length-1] = nse.length;
        var stack = new Stack<Integer>();
        stack.push(bars.length-1);
        for (int i=nse.length-2; i>= 0; i--){
            while (!stack.isEmpty() && bars[i] <= bars[stack.peek()]) {
                stack.pop();
            }

            if (stack.isEmpty()){
                nse[i] = nse.length; // for better calculation
            } else {
                nse[i] = stack.peek();
            }

            stack.push(i);
        }
        return nse;
    }
}
