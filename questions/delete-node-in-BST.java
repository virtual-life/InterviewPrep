/**
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree).

Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7
*/

 public static class TreeNode {  
  int data;  
  TreeNode left;  
  TreeNode right;  
  
  TreeNode(int data) {  
   this.data = data;  
  }  
 }
 
 
public class MinBST {   
  
 // Get minimum element in binary search tree  
 public static TreeNode minimumElement(TreeNode root) {  
    if (root.left == null)  
      return root;  
    else {  
      return minimumElement(root.left);  
    }  
 }  
  
 public static TreeNode deleteNode(TreeNode root, int value) {  
    if (root == null)  
      return null;  
    if (root.data > value) {  
      root.left = deleteNode(root.left, value);  
    } else if (root.data < value) {  
      root.right = deleteNode(root.right, value);   
    } else {
      TreeNode temp = root;  
      // if nodeToBeDeleted have both children  
      if (root.left != null && root.right != null) {  
        // Finding minimum element from right  
        TreeNode minNodeForRight = minimumElement(temp.right);  
        // Replacing current node with minimum node from right subtree  
        temp.data = minNodeForRight.data;  
        // Deleting minimum node from right now  
        deleteNode(temp.right, minNodeForRight.data);   
      }  
      // if nodeToBeDeleted has only left child  
      else if (temp.left != null) {  
        temp = temp.left;  
      }  
      // if nodeToBeDeleted has only right child  
      else if (temp.right != null) {  
        temp = temp.right;  
      }  
      // if nodeToBeDeleted do not have child (Leaf node)  
      else  
        temp = null;  
    }  
  return root;  
 }  

Read more at http://www.java2blog.com/2016/04/how-to-delete-node-from-binary-search.html#qZ54WAhZBhSgaBEm.99
