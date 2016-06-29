/**
 Given an unsorted array of integers, find the length of longest increasing subsequence.

 For example,
 Given [10, 9, 2, 5, 3, 7, 101, 18],
 The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

 Your algorithm should run in O(n2) complexity.

 Follow up: Could you improve it to O(n log n) time complexity?


 */

import java.util.Arrays;

/**
  Time - O(n^2)
 where dp[i] means the length of the LIS, including the ith character.
 */

public class Solution {
    public int maxLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length + 1];
        for (int i = 1; i < nums.length + 1; i++) {
            dp[i] = 1;
        }

        int maxLen = 1;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j < i; j++) {
                if (nums[i - 1] > nums[j - 1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }

    /**
     * Time - O(n logn )
     * https://leetcode.com/discuss/67609/short-java-solution-using-dp-o-n-log-n
     */

        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            int len = 0;

            for (int x : nums) {
                int i = Arrays.binarySearch(dp, 0, len, x);
                if (i < 0) i = -(i + 1);
                dp[i] = x;
                if (i == len) len++;
            }

            return len;
        }

}
