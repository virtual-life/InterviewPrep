/**
 Given two sequences, print the longest subsequence present in both of them.

 Examples:
 LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.

 Time - O(mn)
 
 Consider the input strings “ABCDGH” and “AEDFHR. 
 
 Last characters do not match for the strings. So length of LCS can be written as:
 
 LCS(“ABCDGH”, “AEDFHR”) = MAX ( LCS(“ABCDG”, “AEDFHR”), LCS(“ABCDGH”, “AEDFH”) )

This is basically the priciple behind diff or vimdiff 

 */

/*
 Recursive - overlapping sub problems 
 Time - O(2^n) in worst case and worst case happens when all characters of X and Y mismatch i.e., length of LCS is 0.

*/

 public int lcs(String a, String b, int aLen, int bLen) { 
  
    if (aLen == 0 || bLen == 0) 
      return 0; 
  
    if (a.charAt(aLen -1) == b.charAt(bLen -1)) // checking if last character is the same
      return 1 + lcs(a, b, aLen-1, bLen-1); 
    else
      return Math.max(lcs(X, Y, aLen, bLen-1), lcs(X, Y, aLen-1, bLen)); 
} 


// dp[i][j] - LCS of 2 strings of length i and j 
// Time - O(mn) 

public class Solution {
    public static int getLongestCommonSubsequence(String a, String b){
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }else if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        String lcs = printLCS(dp, m,n,a ,b);
        System.out.println("LCS is "+lcs);
        return dp[m][n];
    }

    public static String printLCS(int[][] dp, int m , int n, String a, String b){

        // Create a character array to store the lcs string
        int index = dp[m][n];
        char[] ch = new char[index];

        // Start from the right-most-bottom-most corner and
        // one by one store characters in lcs[]
        int i = m, j = n;
        while (i > 0 && j > 0){
         
            // If current character in a & b  are same, then
            // current character is part of LCS
            if (a.charAt(i-1) == b.charAt(j-1) ){
             
                ch[index-1] = a.charAt(i-1);
                i--; 
                j--; 
                index--;
            }

            // If not same, then find the larger of two and
            // go in the direction of larger value
            else if (dp[i-1][j] > dp[i][j-1])
                i--;
            else
                j--;
        }

        return new String(ch);
    }

}
