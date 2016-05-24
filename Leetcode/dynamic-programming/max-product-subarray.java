/**
 Find the contiguous subarray within an array (containing at least one number) which has the largest product.

 For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
 */

public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int min = nums[0];
        int max = nums[0];

        int result = nums[0];

        for (int i = 1; i < len; i++) {

            int curMin = Math.min(
                    Math.min(min * nums[i], max * nums[i]),
                    nums[i]);
            int curMax = Math.max(
                    Math.max(max * nums[i], min * nums[i]),
                    nums[i]);

            min = curMin;
            max = curMax;
            result = Math.max(result, max);
        }

        return result;
    }
}