/**
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[2, 2, 3]

Time - O((n+k)!) where n is the size of candidates, 
      and k is the max repeated times for each candidates
Space - O(m) where m is the size of array for the solution.

This is basically a backtraking solution 

*/

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        helper(candidates, result, new ArrayList<Integer>(), 0, target);
        return result;        
    }
    
    private void helper(int[] candidates, List<List<Integer>> result, ArrayList<Integer> temp, int start, int target) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
              
            if(candidates[i] <= target ){     
                temp.add(candidates[i]);
                helper(candidates, result, temp, i, target - candidates[i]);
                temp.remove(temp.size() - 1); 
            }                  
        }
    }
}

// Extenstion : Each number can be used ONLY ONCE
// check the prev condition 


public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        helper(candidates, result, new ArrayList<Integer>(), 0, target);
        return result;        
    }
    
    private void helper(int[] candidates, List<List<Integer>> result, ArrayList<Integer> temp, int start, int target) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        
        int prev=-1;
        for (int i = start; i < candidates.length; i++) {
              
            if(candidates[i] <= target && prev!=candidates[i]){     
                temp.add(candidates[i]);
                helper(candidates, result, temp, i, target - candidates[i]);
                temp.remove(temp.size() - 1);
                prev=candidates[i];  
            }                  
        }
    }
}


