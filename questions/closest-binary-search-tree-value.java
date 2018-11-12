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
