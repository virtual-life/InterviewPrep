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

        return printPaths(root,new ArrayList<>(),"");
    }

    public List<String> printPaths(TreeNode node, List<String> path, String lpath){
        if(node==null){
            return path;
        }
        if(lpath != ""){
            lpath = lpath+"->"+node.val;

        }else{
            lpath = lpath+node.val;
        }

        if(node.left==null && node.right==null){
            path.add(lpath);
            return path;
        }
        else{
            printPaths(node.left,path, new String(lpath));
            printPaths(node.right,path, new String(lpath));
        }
        return path;
    }
}