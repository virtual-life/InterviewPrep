/**
 Find the contiguous subarray within an array (containing at least one number) which has the largest product.

 For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
 
 Time O(n) Space O(1)
 */
 
 
 /*
 You have three choices to make at any position in array.
1. You can get maximum product by multiplying the current element with 
    maximum product calculated so far.  (might work when current 
    element is positive).
2. You can get maximum product by multiplying the current element with 
    minimum product calculated so far. (might work when current 
    element is negative).
3.  Current element might be a starting position for maximum product sub
     array
     
 curr_max_prod = A[0];
prev_max_prod = A[0];
prev_min_prod = A[0];
ans = A[0];
for i=1  to  n-1
{
     curr_max_prod = MAX ( prev_max_prod*A[i],  
                                                 prev_min_prod*A[i], 
                                                 A[i] );

     curr_min_prod = MIN ( prev_max_prod*A[i],  
                                                 prev_min_prod*A[i], 
                                                 A[i] );
     Ans = MAX(ans, curr_max_prod);
     prev_max_prod = curr_max_prod;
     prev_min_prod = curr_min_prod;
}
return ans;

 */

public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        // min negative product ending at the current position
        int min = nums[0];
        // max positive product ending at the current position
        int max = nums[0];
        // Overall max product
        int result = nums[0];

        for (int i = 1; i < len; i++) {

            int curMin = Math.min( 
                    Math.min(max * nums[i], min * nums[i]), 
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
