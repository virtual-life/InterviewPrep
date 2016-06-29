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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null)
            return null;
        if(root == p || root == q)
            return root;

        TreeNode llca = lowestCommonAncestor(root.left,p,q);
        TreeNode rlca = lowestCommonAncestor(root.right,p,q);

        if( llca != null && rlca != null)
            return root;
        return llca != null ? llca:rlca;

    }
}