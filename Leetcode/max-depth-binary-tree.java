/**
 Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 Time - O(m+n)
 DFS

 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int max = 0;
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        maxDepthHelper(root, 0);

        return max;
    }

    private void maxDepthHelper(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        depth++;

        if (root.left == null && root.right == null) {
            if (depth > max) {
                max = depth;
            }
            return;
        }

        maxDepthHelper(root.left, depth);
        maxDepthHelper(root.right, depth);
    }
}