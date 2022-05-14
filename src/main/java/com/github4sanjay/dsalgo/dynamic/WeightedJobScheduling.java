package com.github4sanjay.dsalgo.dynamic;

import java.util.Arrays;
import java.util.Comparator;

/*
 Weighted Job Scheduling in O(n Log n) time
 Difficulty Level : Hard
 Last Updated : 22 Feb, 2022
 Given N jobs where every job is represented by following three elements of it.

 Start Time
 Finish Time
 Profit or Value Associated
 Find the maximum profit subset of jobs such that no two jobs in the subset overlap.
 Example:

 Input: Number of Jobs n = 4
        Job Details {Start Time, Finish Time, Profit}
        Job 1:  {1, 2, 50}
        Job 2:  {3, 5, 20}
        Job 3:  {6, 19, 100}
        Job 4:  {2, 100, 200}
 Output: The maximum profit is 250.
 We can get the maximum profit by scheduling jobs 1 and 4.
 Note that there is longer schedules possible Jobs 1, 2 and 3
 but the profit with this schedule is 20+50+100 which is less than 250.
*/
public class WeightedJobScheduling {

  public static class Job {
    int start, finish, profit;

    Job(int start, int finish, int profit) {
      this.start = start;
      this.finish = finish;
      this.profit = profit;
    }
  }

  private static int findMaxProfit(Job[] arr, int n) {
    int[][] jobs = new int[n][3];
    for (int i = 0; i < n; i++) {
      jobs[i][0] = arr[i].start;
      jobs[i][1] = arr[i].finish;
      jobs[i][2] = arr[i].profit;
    }

    int[] dp = new int[n];
    dp[0] = jobs[0][2];

    for (int i = 1; i < n; i++) {
      dp[i] = Math.max(jobs[i][2], dp[i - 1]);
      for (int j = i - 1; j >= 0; j--) {
        if (jobs[j][1] <= jobs[i][0]) {
          dp[i] = Math.max(dp[i], jobs[i][2] + dp[j]);
          break;
        }
      }
    }

    int ans = Integer.MIN_VALUE;
    for (int val : dp) {
      ans = Math.max(ans, val);
    }
    return ans;
  }

  public static int find(int[][] jobs) {
    Job[] arr = new Job[jobs.length];
    for (int i = 0; i < jobs.length; i++) {
      arr[i] = new Job(jobs[i][0], jobs[i][1], jobs[i][2]);
    }

    // greedy + db
    Arrays.sort(arr, Comparator.comparingInt(job -> job.finish));
    return findMaxProfit(arr, jobs.length);
  }
}
