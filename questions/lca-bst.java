/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * pre-order traversal
 *
 * O(n)
 */

public class Solution {
    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null)
            return null;
        if(root == p || root == q)
            return root;

        if(root.val > p.val && root.val < q.val)
            return root;
            //Search left subtree
        else if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestorBST(root.left,p,q);
            //Search right subtree
        else if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestorBST(root.right,p,q);


    }
}