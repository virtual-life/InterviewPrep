import java.util.ArrayList;
import java.util.List;

/**
 Given a binary tree, return all root-to-leaf paths.

 For example, given the following binary tree:

 1
 /   \
 2     3
 \
 5
 All root-to-leaf paths are:

 ["1->2->5", "1->3"]
 */

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
     
        List<String> result = new ArrayList<String>();

        return printPaths(root,result,"");
    }

    // pre-order traversal
    public List<String> printPaths(TreeNode node, List<String> result, String path){
       
       /* IMPROTANT STEP */
       if( node == null){
            return result;
        }
     
        if(path != ""){
            path = path+"->"+node.val;

        }else{
            path = path+node.val;
        }
        // if leaf node add it to the result and return 
        if(node.left==null && node.right==null){
            result.add(path);
            return result;
        }
        else{
            printPaths(node.left,result, new String(path));
            printPaths(node.right,result, new String(path));
        }
        return path;
    }
}
