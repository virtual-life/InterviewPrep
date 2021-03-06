/**
Given two strings S and T, determine if they are both one edit distance apart.
http://buttercola.blogspot.com/2015/08/leetcode-one-edit-distance.html

There are several cases to consider:
  -- If the len1 - len2 > 1, return false; 
  -- We compare each character of the two strings. if not equal. 
   -- If len1 > len2, we move i++, which means delete one character from string1, e.g. abc, ac
   -- If len1 < len2, we move j++, which means add one character for string1 (or delete one from string 2).
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
 Edit distance between 2 words  - http://professorjava.weebly.com/edit-distance.html
 Time -  O(mn)
 Space - O(mn)
*/

/**
It is important to note that there are only three possibilities one string can get to another: either deleting, inserting, or changing. 
Thus, if we let dp(i,j) indicate the cost it takes from changing i to j, if s and t are the original strings, the cost is:
Math.min(1+dp(i-1,j-1),1+dp(i,j-1),1+dp(i-1,j)) unless the last characters of the strings are the same, then the minimum is dp(i-1,j-1). 
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

// Recursion 
// https://www.geeksforgeeks.org/edit-distance-dp-5/

static int editDist(String str1 , String str2 , int m ,int n) { 
  
    // If first string is empty, the only option is to 
    // insert all characters of second string into first 
    if (m == 0) return n; 
       
    // If second string is empty, the only option is to 
    // remove all characters of first string 
    if (n == 0) return m; 
       
    // If last characters of two strings are same, nothing 
    // much to do. Ignore last characters and get count for 
    // remaining strings. 
    if (str1.charAt(m-1) == str2.charAt(n-1)) 
        return editDist(str1, str2, m-1, n-1); 
       
    // If last characters are not same, consider all three 
    // operations on last character of first string, recursively 
    // compute minimum cost for all three operations and take 
    // minimum of three values. 
    return 1 + min ( editDist(str1,  str2, m, n-1),    // Insert  -> ab, abc 
                     editDist(str1,  str2, m-1, n),   // Remove  -> abc, ab 
                     editDist(str1,  str2, m-1, n-1) // Replace  -> ab, cd                     
                   ); 
    } 
