/**
 Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

 For example,
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

 The time complexity is O(n). The space complexity is O(n) as well since we used two additional arrays.
 */

/**

 The trapped water for slot i is determined by min(leftMostHeight[i], rigthMostHeight[i]) - A[i],

 */

public class Solution {
    public int trap(int[] A) {
        if (A == null || A.length <= 2) {
            return 0;
        }

        int[] maxLeft = new int[A.length];
        int[] maxRight = new int[A.length];
        int max = 0;
        int sum = 0;

        /** Iterate through the array to get the left highest and right highest for i. */
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] > max) {
                max = A[i - 1];
            }
            maxLeft[i] = max;
        }

        max = 0;
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i + 1] > max) {
                max = A[i + 1];
            }
            maxRight[i] = max;
        }

        /**  calculate the trapped water */

        for (int i = 0; i < A.length; i++) {
            int water = Math.min(maxLeft[i], maxRight[i]) - A[i];
            if (water > 0) {
                sum += water;
            }
        }
        return sum;
    }
}