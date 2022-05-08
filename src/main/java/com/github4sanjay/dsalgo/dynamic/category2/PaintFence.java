package com.github4sanjay.dsalgo.dynamic.category2;

/**
 * Given a fence with n posts and k colors, find out the number of ways of painting the fence such
 * that at most 2 adjacent posts have the same color. Since answer can be large return it modulo
 * 10^9 + 7. Examples:
 *
 * <p>Input : n = 2 k = 4 Output : 16 We have 4 colors and 2 posts. Ways when both posts have same
 * color : 4 Ways when both posts have diff color : 4*(choices for 1st post) * 3(choices for 2nd
 * post) = 12
 *
 * <p>Input : n = 3 k = 2 Output : 6
 */
public class PaintFence {

  public static void main(String[] args) {
    System.out.println(PaintFence.find(8, 3));
  }

  private static int find(int fence, int colors) {
    return findDP(fence, colors); // 3672
    // return findBruteForce(fence, colors, 0, ""); // 3672
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
