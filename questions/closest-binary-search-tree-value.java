/*

Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

*/


// pre-order traversal 

public class Solution {

    int result = -1;
    double min = Double.MAX_VALUE;
 
    public int closestValue(TreeNode root, double target) {
        helper(root, target);
        return result;
    }
 
    public void helper(TreeNode root, double target){
        if(root==null)
            return;
 
        if(Math.abs(root.val - target) < min){
            result = root.val;
            min = Math.abs(root.val-target);
            
        } 
 
        if(target < root.val){
            helper(root.left, target);
        }else{
            helper(root.right, target);
        }
    }
}

// iterative 

public class Solution {
    public int closestValue(TreeNode root, double target) {
            
        int result = -1;
        double min = Double.MAX_VALUE;
        
        if (root == null) {
            return result;
        }
         
        while (root != null) {
        
            if (root.val == target) {
                return root.val;
            }
            
            if (Math.abs(root.val - target) < min) {
                result = root.val;
                min = Math.abs(root.val - target);
            }
             
            if (target > root.val) {
                root = root.right;
            } else if (target < root.val) {
                root = root.left;
            }
        }
        return result;
    }
}

/*
    Find K closest nodes
   
*/

// In- order traversal 
// Time - O(n) Space O(k)

public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Queue<Integer> result = new Queue<Integer>();
        closestKValuesHelper(result, root, target, k);
        return list;
    }
    
    /**
     * @return true if result is already found.
     */
    private boolean closestKValuesHelper(Queue<Integer> result, TreeNode root, double target, int k) {
        
        if (root == null) {
            return false;
        }
        
        if (closestKValuesHelper(result, root.left, target, k)) {
            return true;
        }
        
        if (result.size() == k) {
            if (Math.abs(result.peek() - target) < Math.abs(root.val - target)) { // if current value is greater than begin of queue
                return true;
            } else {
                result.poll();
            }
        }  
        
        result.offer(root.val);
        
        
        return closestKValuesHelper(list, root.right, target, k);
    }
}

// Time - O(k log N )
https://leetcode.com/problems/closest-binary-search-tree-value-ii/discuss/70503/O(logN)-Java-Solution-with-two-stacks-following-hint

