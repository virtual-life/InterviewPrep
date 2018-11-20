import java.util.ArrayList;
import java.util.Arrays;

/**

 Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note:
 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 The solution set must not contain duplicate triplets.
 For example, given array S = {-1 0 1 2 -1 -4},

 A solution set is:
 (-1, 0, 1)
 (-1, -1, 2)

 O(n^2)

 */

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        final int length = num.length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (length < 3) return result;

        /** Sort the array */
        Arrays.sort(num);

        for (int i = 0; i < length - 2; i++) {
   
            if (i == 0 || num[i] > num[i - 1]) { // 2nd condition is to handle duplicate elements
                int target = 0 - num[i];
                int start = i + 1;
                int end = length - 1;
                while (start < end) {
                    if (num[start] + num[end] == target) {
                        ArrayList<Integer> elem = new ArrayList<Integer>();
                        elem.add(num[i]);
                        elem.add(num[start]);
                        elem.add(num[end]);

                        result.add(elem);
                        start++;
                        end--;

                        /** Remove duplicated results ( if array has duplicate elements ) */
                        while (start < end && num[end + 1] == num[end]) end--;
                        while (start < end && num[start - 1] == num[start]) start++;
                    } else
                    if (num[start] + num[end] > target)
                        end--;
                    else
                        start++;
                }
            }
        }
        return result;
    }
}

/*
 find one triplet 
Time - O(n^2)
*/

class Solution { 
  
    // returns true if there is triplet with sum equal 
    // to 'sum' present in A[]. Also, prints the triplet 
    boolean find3Numbers(int A[], int arr_size, int sum) 
    { 
        int l, r; 
  
        /* Sort the elements */
        Arrays.sort(A);
  
        /* Now fix the first element one by one and find the 
           other two elements */
        for (int i = 0; i < arr_size - 2; i++) { 
  
            // To find the other two elements, start two index variables 
            // from two corners of the array and move them toward each 
            // other 
            l = i + 1; // index of the first element in the remaining elements 
            r = arr_size - 1; // index of the last element 
            while (l < r) { 
                if (A[i] + A[l] + A[r] == sum) { 
                    return true; 
                } 
                else if (A[i] + A[l] + A[r] < sum) 
                    l++; 
  
                else // A[i] + A[l] + A[r] > sum 
                    r--; 
            } 
        } 
  
        // If we reach here, then no triplet was found 
        return false; 
    } 


/**
3Sum closets

Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

For example, given array S = {-1 2 1 -4}, and target = 1. 
The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Analysis

This problem is similar to 2 Sum. This kind of problem can be solved by using a similar approach, i.e., two pointers from both left and right.
*/

public int threeSumClosest(int[] nums, int target) {
    int min = Integer.MAX_VALUE;
	   int result = 0;
 
	   Arrays.sort(nums);
 
	   for (int i = 0; i < nums.length; i++) {
		     int j = i + 1;
		     int k = nums.length - 1;
		     while (j < k) {
			        int sum = nums[i] + nums[j] + nums[k];
			        int diff = Math.abs(sum - target);
 
			        if(diff == 0) 
               			     return sum;
 
			        if (diff < min) {
				           min = diff;
				           result = sum;
			        }
			       if (sum <= target) {
				             j++;
			       } else {
				            k--;
			       }
		    }
	}
 
	return result;
}
