/**
Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6


*/


public class Solution {
    public int evalRPN(String[] tokens) {
       int result = 0;
       Stack<String> stack = new Stack<String>();
       for(int i = 0 ;i<tokens.length;i++){
           if(isInteger(tokens[i])){
               stack.push(tokens[i]);
           }else{
             if(!stack.isEmpty()){
               Integer op1 = Integer.parseInt(stack.pop());
               Integer op2 = Integer.parseInt(stack.pop());
               switch(tokens[i]){
                case "*":
                    stack.push(Integer.toString(op1 * op2));
                    break;
                case "+":
                   stack.push(Integer.toString(op1 + op2));
                    break;
                case "-":
                   stack.push(Integer.toString(op2 - op1));
                    break; 
                case "/":
                   stack.push(Integer.toString(op2 / op1));
                    break; 
               }
             }
           }
       } 
       
       result = Integer.parseInt(stack.pop());
       
       return result;
    }
    
    public static boolean isInteger(String s) {
      boolean isValidInteger = false;
      try
      {
         Integer.parseInt(s);
 
         // s is a valid integer
 
         isValidInteger = true;
      }
      catch (NumberFormatException ex)
      {
         // s is not an integer
      }
 
      return isValidInteger;
   }
}
