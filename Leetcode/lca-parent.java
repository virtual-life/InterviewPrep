/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode parent;
 *     TreeNode(int x) { val = x; }
 * }
 *
 *
 * O(h)
 */
public class Solution {

    TreeNode lowestCommonAncestor(TreeNode p, TreeNode q)
    {
        // Creata a map to store ancestors of p
        HashMap<TreeNode, boolean> ancestors = new HashMap<TreeNode, boolean>();

        // Insert p and all its ancestors in map
        while (p != NULL)
        {
            ancestors.put(p,true);
            n1 = p.parent;
        }

        // Check if q or any of its ancestors is in map
        while (q != NULL)
        {
            if(map.containsKey(q)){
                return q;
            }
            q = q.parent;
        }

        return null;
    }
}