/**
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, 
the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.

Time - O(n)
Space - O(1)

*/

/**
dp[n] = maximum amount of money that has been earned when the robber reaches the n-th house. 
*/

public class Solution {
    public int rob(int[] nums) {
    
        if(nums.length <= 1){
            return nums.length == 0 ? 0 : nums[0];
        }
  
        int a = nums[0];      
        int b = Math.max(nums[0], nums[1]);
        
        for(int i = 2; i < nums.length; i++){
            int tmp = b;          
            b = Math.max(a + nums[i], b); // dp[i] = max (arr[i] + dp[i-2], dp[i-1])
            a = tmp;
        }
        return b; // dp[n-1]
    }
}

public class Solution {
    public int rob(int[] nums) {
        
    if(nums==null||nums.length==0)
        return 0;
 
    if(nums.length==1)
        return nums[0];
 
    int[] dp = new int[nums.length];
        
    dp[0]=nums[0]; // number of way of robbing 0 
    dp[1]=Math.max(nums[0], nums[1]); // first house is either picked or not 
 
    for(int i=2; i<nums.length; i++){
        dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]); // (cur + one before last) or previous 
    }
 
    return dp[nums.length-1]; // dp[n-1]
}
}    

/**
After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. 
This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.

Time - O(n)
Space - O(1)

*/


public class Solution {
    
    public int rob(int[] nums) {
        // Robbed 1st house, but not last .... Robbed last but not 1st 
        return Math.max(rob(nums, 0), rob(nums, 1));
    }
    
    public int rob(int[] nums, int offset) {
        
        if(nums==null||nums.length==0)
            return 0;
 
        if(offset == nums.length)
            return nums[offset];
   
        int a = nums[offset];        
        int b = Math.max(nums[offset], nums[offset + 1]);
       
        //check for loop condition 
        for(int i = offset + 2; i < nums.length + offset -1 ; i++){
            int tmp = b;
            b = Math.max(a + nums[i], b);
            a = tmp;
        }
        return b;
    }
}


/**
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." 
Besides the root, each house has one and only one parent house. 
After a tour, the smart thief realized that "all houses in this place forms a binary tree". 
It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
     3
    / \
   2   3
    \   \ 
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \ 
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.

Time - O(n)
Space - O(logn) - stack 

*/

/*
Traverse down the tree recursively. We can use an array to keep 2 values: 
the maximum money when a root is selected and the maximum value when a root if NOT selected.


*/
public int rob(TreeNode root) {
    if(root == null)
        return 0;
 
    int[] result = helper(root);
    return Math.max(result[0], result[1]);
}
 
public int[] helper(TreeNode root){
    if(root == null){
        int[] result = {0, 0};
        return result;
    }
 
    int[] result = new int[2];
    int[] left = helper(root.left);
    int[] right = helper (root.right);
 
    // result[0] is when root is selected, result[1] is when not. 
    result[0] = root.val + left[1] + right[1];
    result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
 
    return result;
}






