/**
 You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 Time - O(n)
 Dynamic Programming

 Solution for i = One step + 2 steps
 So dp[i] = dp[i - 1] + dp[i - 2].

 */

public class Solution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public int climbStairsConstantSpace(int n) {
        if (n <= 0) {
            return 0;
        }

        int dp_i = 1;
        int dp1 = 1;
        int dp2 = 1;

        for (int i = 2; i <= n; i++) {
            dp_i = dp1 + dp2;
            dp2= dp1;
            dp1 = dp_i;
        }

        return dp_i;
    }
}