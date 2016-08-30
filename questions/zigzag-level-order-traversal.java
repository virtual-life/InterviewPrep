/**

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]

*/

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> zlot = new ArrayList<List<Integer>>();
        if(root == null){
            return zlot;
        }
        
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        int count = 0;
        
        queue.add(root);
        int levelNodes = 0;
        
        while(!queue.isEmpty()){
            levelNodes = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            
            while(levelNodes > 0){
                
                TreeNode n = queue.poll();
                if(count%2 == 0){
                    list.add(n.val);
                }else{
                    //add to begining of list 
                    list.add(0,n.val);
                } 
                
                if(n.left != null){
                    queue.add(n.left);
                }
                if(n.right != null){
                    queue.add(n.right);
                } 
                levelNodes--;
            }
                     
            count++;
            zlot.add(list);   
            
        }
        
        return zlot;
    }
}
