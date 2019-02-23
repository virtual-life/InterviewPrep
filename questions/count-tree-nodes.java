/*
Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input: 
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6

*/

/*

The idea is simple, if the height of left sub tree is the same to the right sub tree, 
we know that left sub tree is a full binary tree, so the total count of the nodes in left sub tree plus the root node is 2^h 
where h is the height of left sub tree, then we just need to count the nodes in right sub tree.

The bit manipulation in this code is doing the calculation of 2^h.


get the height of left and right subtree
compare the height
if left == right, then the left subtree must be complete
if left > right, then the right subtree must be complete
if a subtree is complete, the number of whole subtree + the root = 2^subtree height
recursion


*/

public class Solution {

  public int countNodes(TreeNode root) {
    if (root == null)
      return 0;
            
    int hLeft = getHeight(root.left);
    int hRight = getHeight(root.right);
        
    // left tree is complete    
    if (hLeft == hRight)
      return (1 << hLeft) + countNodes(root.right); // bit manipulation part of equivalent to 2^h  or (int)Math.pow(2,hLeft)
    else
      return (1 << hRight) + countNodes(root.left);
    
  }
    
  int getHeight(TreeNode root) {
    if (root == null)
      return 0;
        
    return 1 + Math.max(getHeight(root.left), getHeight(root.right));
  }

}
