package com.github4sanjay.dsalgo.backtracking;

/**
 * This question is also known as Josephus problem. This problem states that:- there are n people
 * standing in a circle waiting to be executed. The counting out begins at some point in the circle
 * and proceeds around the circle in a fixed direction. In each step, a certain number of people are
 * skipped and the next person is executed. The elimination proceeds around the circle (which is
 * becoming smaller and smaller as the executed people are removed), until only the last person
 * remains, who is given freedom. Given the total number of persons n and a number k which indicates
 * that k-1 persons are skipped and kth person is killed in circle. The task is to choose the place
 * in the initial circle so that you are the last one remaining and so survive.
 */
public class JosephusCircle {

  // solution considers from index 0
  public static int find(int n, int k) {
    if (n == 1) return 0;
    int survivor = find(n - 1, k);
    return (survivor + k) % n;
  }
}
