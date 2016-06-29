/**
 Given a binary tree, determine if it is a valid binary search tree (BST).

 Time - O(n) inorder or iterative
 */

public class Solution {
    public boolean isValidBSTRecursive(TreeNode root) {

        return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    public boolean isValidBST(TreeNode root, double min, double max){
            if(root==null)
                return true;

            if(root.val <= min || root.val >= max)
                return false;

            return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }


    /**
     If the violation occurs close to the root but on the right subtree, the above method still cost O(n).
     Iterative solution below can handle violations close to root node faster. -

     http://www.programcreek.com/2012/12/leetcode-validate-binary-search-tree-java/

     */





}

