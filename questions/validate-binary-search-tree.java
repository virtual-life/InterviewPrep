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

}
    /**
     If the violation occurs close to the root but on the right subtree, the above method still cost O(n).
     Iterative solution below can handle violations close to root node faster. -

     http://www.programcreek.com/2012/12/leetcode-validate-binary-search-tree-java/

     */

  
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
 
        LinkedList<BNode> queue = new LinkedList<BNode>();
        queue.add(new BNode(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY));
        while(!queue.isEmpty()){
            BNode b = queue.poll();
            if(b.n.val <= b.left || b.n.val >=b.right){
                return false;
            }
            if(b.n.left!=null){
                queue.offer(new BNode(b.n.left, b.left, b.n.val));
            }
            if(b.n.right!=null){
                queue.offer(new BNode(b.n.right, b.n.val, b.right));
            }
        }
        return true;
    }
}
//define a BNode class with TreeNode and it's boundaries
class BNode{
    TreeNode n;
    double left;
    double right;
    public BNode(TreeNode n, double left, double right){
        this.n = n;
        this.left = left;
        this.right = right;
    }
}




