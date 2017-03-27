/**
Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
Example 2:
Input:

"cbbd"
Output:
2
One possible longest palindromic subsequence is "bb".

Time - O(n^2)
Space - O(n^2)
http://algorithms.tutorialhorizon.com/longest-palindromic-subsequence/

*/

/**
Check the first and the last characters of the sequence. Now there are two possibilities, either both the characters same or distinct. 
We will have to handle both the case.

If both characters are same, add 2 to the result and remove both the characters and solve the problem for the remaining subsequence.

If both characters are different, then solve the problem twice, ignore the first character (keep the last character)and solve the remaining subsequence and 
then ignore the last character (keep the first character) and solve it and pick the best out of two results


Recursive Equations:

dp[i, i]	=	1	                                Every single character is a palindrome by itself of length 1
dp[i, j]	=	2	                                if j=i+1, sequence has only 2 characters
dp[i, j]	=	2 + dp[i+1, j-1]	                If first and last characters are same
dp[i, j]	=	MAX(dp[i+1,j], dp[i, j-1])	    If first and last characters are not same

*/

public class Solution {
    public int longestPalindromeSubseq(String s) {
    
      if(s == null || s.length() == 0){
              return 0;
      }
          
      int n = s.length();
      int [][] dp = new int[n][n];
        
      for(int i = 0; i< n; i++){
          dp[i][i] = 1;  // Strings of length 1 are palindrome of lentgh 1
      }    
      
      for(int sublen=2; sublen<=n; sublen++){          
          for(int i=0;i<=n-sublen;i++){
              
             int j = i+sublen-1;
             if(s.charAt(i) == s.charAt(j) && sublen==2){
                 dp[i][j] = 2;
             }
             else if(s.charAt(i) == s.charAt(j)){
                dp[i][j] = dp[i+1][j-1] + 2;
             }
             else{
                dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
             }
           }
       }
       return dp[0][n-1];        
    }
}
