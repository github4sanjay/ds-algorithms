package com.github4sanjay.dsalgo.dynamic.arrangements;

/*
 * Given a fence with n posts and k colors, find out the number of ways of painting the fence such that at most
 * 2 adjacent posts have the same color. Since answer can be large return it modulo 10^9 + 7.
 * Examples:
 *
 * Input : n = 2 k = 4
 * Output : 16
 * We have 4 colors and 2 posts.
 * Ways when both posts have same color : 4
 * Ways when both posts have diff color :
 * 4*(choices for 1st post) * 3(choices for
 * 2nd post) = 12
 *
 * Input : n = 3 k = 2
 * Output : 6
 */
public class PaintFence {

  /**
   * Let’s define function f(n) is for calculating how many ways to paint a fence with n points and
   * k colors. So here I want to figure out the relationship between function f(n) for n points
   * fence and less points fence solutions like f(n-1), f(n-2), f(n-3);
   *
   * <p>f(n) = f(n-1)*k
   *
   * <p>Here the first thought would be f(n) is actually f(n-1) multiply k colors ways. But what
   * could happen is that there may exists some invalid paint ways if the last 1st color is
   * equivalent to the last 2nd and last 3rd color. Okay, then to me the way to avoid these invalid
   * ways is just subtract those invalid ways from f(n-1).k. So the only invalid ways for paint
   * fence with appending the last color is f(n-3) * (k-1). That’s because it will only be invalid
   * if the last 3 colors are the same. Let’s assume that both f(n-3) and f(n -2) are valid result,
   * which means the last 3rd color is mush not equivalent to the last 4th color. And then the last
   * 3 colors have (k-1) different choices
   *
   * <p>Then the new formula will be
   *
   * <p>f(n) = f(n-1)*k- f(n-3)*(k-1)
   */
  public static int recursion(int n, int k) {
    if (n == 1) {
      return k;
    }
    if (n == 2) {
      // same + different
      // k + k*(k-1)
      return k * k;
    }
    if (k < 2) {
      return 0;
    }
    if (n == 3) {
      /*
       * For k = 2
       * with same color k ways
       * with different color k * (k-1) ways
       * total k + k * (k-1) ways
       *
       * For k = 3
       * for same color
       *    put same color as last of different color in k = 2
       *    k * (k-1)
       * for different color
       *    put any other color in total in k = 2
       *    (k + k * (k-1)) * (k-1)
       *
       * total = same + different
       *       = k * (k-1) + (k + k * (k-1)) * (k-1)
       *       = k*k - k + (k + k*k - k) * (k-1)
       *       = k*k - k + k*k*(k-1)
       *       = k*k - k + k*k*k - k*k
       *       = k*k*k - k
       */
      return k * (k * k - 1);
    } else {
      return k * recursion(n - 1, k) - recursion(n - 3, k) * (k - 1);
    }
  }

  public static int find(int fence, int colors) {
    return findDP(fence, colors);
  }

  private static int findDP(int fence, int colors) {
    int same = colors;
    int different = colors * (colors - 1);
    int total = same + different;

    for (int i = 2; i < fence; i++) {
      same = different;
      different = total * (colors - 1);
      total = same + different;
    }
    return total;
  }

  public static int findBruteForce(int fence, int colors) {
    return findBruteForce(fence, colors, 0, "");
  }

  // fence^colors time complexity
  private static int findBruteForce(int fence, int colors, int fenceIndex, String answer) {
    if (fence == fenceIndex) {
      System.out.println(answer);
      return 1;
    }

    int sum = 0;

    if (answer.length() < 2) { // when fence is less than two all color are available
      for (int i = 1; i <= colors; i++) {
        sum += findBruteForce(fence, colors, fenceIndex + 1, answer + i);
      }
    } else { // when fence is greater than two need to check last two colors
      String last = answer.substring(answer.length() - 1);
      String secondLast = answer.substring(answer.length() - 2, answer.length() - 1);
      if (last.equals(
          secondLast)) { // if last two colors are same then that color is not available to next
        // fence
        int notAvailable = Integer.parseInt(last, 10);
        for (int i = 1; i <= colors; i++) {
          if (i == notAvailable) continue; // skip this color
          sum += findBruteForce(fence, colors, fenceIndex + 1, answer + i);
        }
      } else { // if last two colors are not same then all colors are available
        for (int i = 1; i <= colors; i++) {
          sum += findBruteForce(fence, colors, fenceIndex + 1, answer + i);
        }
      }
    }
    return sum;
  }
}
