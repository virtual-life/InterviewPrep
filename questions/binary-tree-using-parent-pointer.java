/**
 * Expects a TreeNode collection where each node points to its parent.
 * Builds the full tree and returns the root (which has to have a
 * null parent).
 */


public class Solution{

    public static TreeNode linkToTree(Iterable<TreeNode> nodes) {

  /** Building the tree.
   *
   *
   * Each node already knows its parent,  add the node
   * as a new child to the parent. We treat a "null" slot as empty.
   * First, we fill the left slot, then overwrite the right slot
   * without any checks – last one wins out.
   */

        TreeNode root;

        for (TreeNode node : nodes) {
            final TreeNode parentNode = node.parent;

            // try to detect the root node
            if (parentNode == null) {
                root = node;
            }
            // add this node to the parent's left slot if it's empty
            else if (parentNode.left == null) {
                parentNode.left = node;
            }
            // … else overwrite right slot
            else {
                parentNode.right = node;
            }
        }

        return root;
    }
}