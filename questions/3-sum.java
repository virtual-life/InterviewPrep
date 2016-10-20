import java.util.ArrayList;
import java.util.Arrays;

/**

 Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note:
 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 The solution set must not contain duplicate triplets.
 For example, given array S = {-1 0 1 2 -1 -4},

 A solution set is:
 (-1, 0, 1)
 (-1, -1, 2)

 O(n^2)

 */

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        final int length = num.length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (length < 3) return result;

        /** Sort the array */
        Arrays.sort(num);

        for (int i = 0; i < length - 2; i++) {
   
            if (i == 0 || num[i] > num[i - 1]) { // 2nd condition is to handle duplicate elements
                int target = 0 - num[i];
                int start = i + 1;
                int end = length - 1;
                while (start < end) {
                    if (num[start] + num[end] == target) {
                        ArrayList<Integer> elem = new ArrayList<Integer>();
                        elem.add(num[i]);
                        elem.add(num[start]);
                        elem.add(num[end]);

                        result.add(elem);
                        start++;
                        end--;

                        /** Remove duplicated results ( if array has duplicate elements ) */
                        while (start < end && num[end + 1] == num[end]) end--;
                        while (start < end && num[start - 1] == num[start]) start++;
                    } else
                    if (num[start] + num[end] > target)
                        end--;
                    else
                        start++;
                }
            }
        }
        return result;
    }
}
