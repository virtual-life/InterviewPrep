/**
 Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom. For example, given the following binary tree,

 1            <---
 /   \
 2     3         <---
 \
 5             <---
 You can see [1, 3, 5].

 */

/** using a queue. On each level of the tree, we add the right-most element to the results. */

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if(root == null) return result;

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(queue.size() > 0){
            //get size here
            int size = queue.size();

            for(int i=0; i<size; i++){
                TreeNode top = queue.remove();

                //the first element in the queue (right-most of the tree)
                if(i==0){
                    result.add(top.val);
                }
                //add right first
                if(top.right != null){
                    queue.add(top.right);
                }
                //add left
                if(top.left != null){
                    queue.add(top.left);
                }
            }
        }

        return result;
    }

}