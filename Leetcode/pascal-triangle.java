import java.util.ArrayList;
import java.util.List;

/**
 Pascal's triangle
 */


public class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        ArrayList<Integer> pre = new ArrayList<Integer>();
        if(numRows >= 1){
            pre.add(1);
            result.add(pre);
        }
        if (numRows <= 1)
            return result;

        for (int i = 2; i <= numRows; i++) {
            ArrayList<Integer> cur = new ArrayList<Integer>();

            cur.add(1); //first
            for (int j = 0; j < pre.size() - 1; j++) {
                cur.add(pre.get(j) + pre.get(j + 1)); //middle
            }
            cur.add(1);//last

            result.add(cur);
            pre = cur;
        }

        return result;

    }
}