/**
A message containing letters from A-Z is being encoded to numbers using the following mapping:
'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.
For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
The number of ways decoding "12" is 2.
Time = O(n)
*/

/*
3 cases 
 - if the current char =='0'
 - if the current char and previous char >26
 - if the previous char =='0'
 
 dp[n] = denote the number of ways to decode a string of length n
 
 dp[i] = dp[i-1]                if S[i-1] is a valid number ( anything other than 0 )
  or   = dp[i-1]+ dp[i-2]       if S[i-1] and S[i-2] together is still a valid number.
  
 Corner cases: there could be “”, “00” or “01”.
  
*/

public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
         
        if (s.charAt(0) == '0') {  // eg 0123 vs 456. 0123 is not a valid decoded number. Basically anything that startswith a 0 is invalid. 
            return 0;
        }
         
        int[] dp = new int[s.length() + 1];
        dp[0] = 1; // if encoded message has zero characters/number . "" has one decoding: "".
        dp[1] = 1;  // is encoded message has one character/number then the number of solution is only 1. "3" has one decoding "C".
         
        for (int i = 2; i <= s.length(); i++) { // length 2 to N 
            if (s.charAt(i - 1) != '0') {   // if S[i-1] is a valid char
                dp[i] = dp[i - 1];
            }
             
            if (isValid(s.substring(i - 2, i))) {
                dp[i] = dp[i] + dp[i - 2];
            }
        }
         
        return dp[s.length()];
    }
     
    private boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return false;
        }
         
        int num = Integer.parseInt(s);
        if (num >= 1 && num <= 26) {
            return true;
        }
         
        return false;
    }
}
