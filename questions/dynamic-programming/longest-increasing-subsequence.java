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
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        int maxLen = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                 
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
     * Using Binary Search 
     */
 
 /*
 Arrays.binarySearch(int[] a, int key) :
 
 This method returns index of the search key, if it is contained in the array, else it returns (-(insertion point) - 1). 
 The insertion point is the point at which the key would be inserted into the array: the index of the first element greater than the key, 
 or a.length if all elements in the array are less than the specified key.

As a result pos is equal to insertion_index, which is equal to dp.length. 
So the dp[pos] = nums[i]; line fails, because pos is out of bounds.

This problem does not happen when searching just part of the array by using Arrays.binarySearch(dp, 0, len, nums[i]), 
because in this case the insertion index is len.
 */

        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            int len = 0;

            for (int i = 0; i<nums.length; i++) {
                int pos = Arrays.binarySearch(dp, 0, len, nums[i]);
                if (pos < 0){ 
                   pos = -(pos + 1);
                }
                dp[pos] = nums[i];
                if (pos == len){
                   len++;
                }
            }

            return len;
        }

}
