/**
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

Time - O(n)
At any point the visited left parentheses should be greater or equal than the visited right parentheses. 
For example, ()()(),  at position 2, the number of left parentheses is 2 while the right one is 1. 
That helps to avoid the case such that () ), which could never be a valid parentheses. 
*/

public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        if (n <= 0) return result;
         
        StringBuilder sb = new StringBuilder();
         
        generateParenthesisHelper(n, 0, 0, sb, result);
         
        return result;
    }
     
    private void generateParenthesisHelper(int n, int left, int right, StringBuilder temp, ArrayList<String> result) {
        if (left < right) return;
         
        if (left == n && right == n) {
            result.add(temp.toString());
            return;
        }
         
        if (left < n) {
            temp.append('(');
            generateParenthesisHelper(n, left + 1, right, temp, result);
            temp.deleteCharAt(temp.length() - 1);
        }
         
        if (right < n) {
            temp.append(')');
            generateParenthesisHelper(n, left, right + 1, temp, result);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
