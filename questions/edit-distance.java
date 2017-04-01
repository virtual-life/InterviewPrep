/**
Given two strings S and T, determine if they are both one edit distance apart.
http://buttercola.blogspot.com/2015/08/leetcode-one-edit-distance.html

There are several cases to consider:
  -- If the len1 - len2 > 1, return false; 
  -- We compare each character of the two strings. if not equal. 
   -- If len1 > len2, we move i++, which means delete one character from string1, e.g. abc, ac
   -- If len1 < len2, we move j++, which add one character for string1 (or delete one from string 2).
  --  If len1 == len2, i++, j++
  
*/


// One Edit Distance

public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if ((s == null || s.length() == 0) && (t == null || t.length() == 0)) {
            return false;
        }
         
        if (s == null || s.length() == 0) {
            return t.length() == 1;
        }
         
        if (t == null || t.length() == 0) {
            return s.length() == 1;
        }
         
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
         
         
        int count = 0;
        int i = 0;
        int j = 0;
         
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) != t.charAt(j)) {
                count++;
                if (count > 1) {
                    return false;
                }
                 
                if (s.length() > t.length()) {
                    i++;
                } else if (s.length() < t.length()) {
                    j++;
                } else {
                    i++;
                    j++;
                }
            } else {
                i++;
                j++;
            }
        }
         
        if (i < s.length() || j < t.length()) {
            count++;
        }
         
        return count == 1;
    }
}

/**
 Edit distance between 2 words  - http://www.programcreek.com/2013/12/edit-distance-in-java/
*/

/**
It is important to note that there are only three possibilities one string can get to another: either deleting, inserting, or changing. 
Thus, if we let dp(i,j) indicate the cost it takes from changing i to j, if s and t are the original strings, the cost is:
Math.min(1+dp(i-1,j-1),1+dp(i,j-1),1+dp(i-1,j)) unless the last characters of the strings are the same, then the minimum is L(i-1,j-1). 
*/

public static int editDistance(String s1, String s2){
    // dp[i][j] is the edit distance between the two string s1 and s2 of length i and j
     int dp[][]=new int[s1.length()+1][s2.length()+1];
     
     for(int i=0;i<=s1.length();i++)
         dp[i][0]=i;
  
     for(int j=1;j<=s2.length();j++)
         dp[0][j]=j;
     
     int disance =0;
     for(int i=1;i<=s1.length();i++){
         for(int j=1;j<=s2.length();j++){
             // if the characters are same distance is 0 else 1
             if( s1.charAt(i-1) == s2.charAt(j-1) ){
               distance=0;
             }else{
               distance=1;
             }  
             dp[i][j]=Math.min(
                             dp[i-1][j]+1,
                             Math.min(
                                dp[i][j-1]+1,
                                dp[i-1][j-1]+distance
                             )
                         );
         }
     }
     return dp[s1.length()][s2.length()];
}
