/*


 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }


Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:

Input: [[1,1],2,[1,1]]
Output: 10 
Explanation: Four 1's at depth 2, one 2 at depth 1.
Example 2:

Input: [1,[4,[6]]]
Output: 27 
Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27.

*/


class Solution {    
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSumCompute(nestedList,1);
    }
    
    public int depthSumCompute(List<NestedInteger> nestedList, int depth){
        
        int sum =0;
        
        for(NestedInteger ni : nestedList){
            if(ni.isInteger()){
                sum = sum + ni.getInteger() * depth;
            }else{
                sum  = sum +depthSumCompute(ni.getList(), depth+1);
            }
        }
        
        return sum;
    }
}



/*
Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. 
i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.

Example 1:

Input: [[1,1],2,[1,1]]
Output: 8 
Explanation: Four 1's at depth 1, one 2 at depth 2.
Example 2:

Input: [1,[4,[6]]]
Output: 17 
Explanation: One 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17.

*/

import java.lang.*;

class Solution {
    
    public int depthSumInverse(List<NestedInteger> nestedList) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        int maxDepth = 1;
        int depth = 1;
        maxDepth = depthSum(nestedList,depth,map,maxDepth); 
        int sum = 0;
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            
            sum = sum + ((maxDepth - entry.getKey() +1) * entry.getValue() );
        }  
        return sum;
    }
    
    public int depthSum(List<NestedInteger> nestedList, int depth, HashMap<Integer,Integer> map, int maxDepth){
        for(NestedInteger ni : nestedList){
            if(ni.isInteger()){
             
                if(map.get(depth) != null){
                    map.put(depth, map.get(depth) + ni.getInteger());
                }else{
                    maxDepth = Math.max(maxDepth, depth);
                    map.put(depth, ni.getInteger());
                }
                
            }else{ // if a list 
                maxDepth = depthSum(ni.getList(), depth+1, map, maxDepth);
            }
        }
     
        return maxDepth;
    }
}

