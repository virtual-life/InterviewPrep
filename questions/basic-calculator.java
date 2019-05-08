/*
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:

Input: "1 + 1"
Output: 2
Example 2:

Input: " 2-1 + 2 "
Output: 3
Example 3:

Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23
Note:
You may assume that the given expression is always valid.
Do not use the eval built-in library function.

*/


class Solution {
    public int calculate(String s) {
        // all possible case: "+", "-", "(", ")", " ", "1-9"
        // +: change sign to positive +1
        // -: change sign to negative -1
        // (: push current result value and sign onto the stack
        // ): pop the previous result value and sign off the stack and do the addition 
        // " ": skip
        // 1-9: read all digits after current digit 
        Deque<Integer> stack = new ArrayDeque<>();
        // initialize result to be 0, sign to be 1
        int res = 0, sign = 1;
        
        int n = s.length();
        // iterate through all characters of the input
        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            switch (curr) {
                case '+':
                    // make sign become positive to indicate we are adding a value
                    sign = 1;
                    break;
                case '-':
                    // make sign become negative to indicate we are subtracting a value 
                    sign = -1;
                    break;
                case '(':
                    // pushing current result as well as the sign onto the stack
                    stack.addFirst(res);
                    stack.addFirst(sign);
                    // reset result and sign 
                    res = 0;
                    sign = 1;
                    break;
                case ')':
                    // popping previous result and sign off the stack and do the addition(subtraction)
                    // with the current calculation result 
                    int prevSign = stack.removeFirst();
                    int prevRes = stack.removeFirst();
                    res = prevRes + prevSign * res;
                case ' ':
                    // skip the empty spaces
                    break;
                default:
                    // in case current char is a digit, read the whole integer 
                    int startIdx = i;
                    while (i < n && Character.isDigit(s.charAt(i))) {
                        i++;
                    }
                    int v = Integer.parseInt(s.substring(startIdx, i));
                    res += sign * v;
                    i--;
            }
        }
        return res;
    }
}
