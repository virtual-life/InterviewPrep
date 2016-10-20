Time - O(E+V)

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> lot = new ArrayList<List<Integer>>();
        if( root == null){
            return lot;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<TreeNode> nextqueue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(node.left != null){
                nextqueue.add(node.left);
            }
            if(node.right != null){
               nextqueue.add(node.right);
            }
            list.add(node.val);
            if(queue.isEmpty()){
                lot.add(list);
                queue = nextqueue;
                nextqueue = new LinkedList<TreeNode>(); 
                list = new ArrayList<Integer>(); 
            }
        }
        
        return lot;
        
    }
}
