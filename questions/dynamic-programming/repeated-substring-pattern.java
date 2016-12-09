/**
Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
Example 1:
Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.
Example 2:
Input: "aba"
Output: False
Example 3:
Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)


Time -  makes use of the information gained by previous symbol comparisons. It never re-compares a text symbol that has matched a pattern symbol. 
As a result, the complexity of the searching phase of the Knuth-Morris-Pratt algorithm is in O(n).
*/

/**
Roughly speaking, dp[i+1] stores the maximum number of characters that the string is repeating itself up to position i.
Therefore, if a string repeats a length 5 substring 4 times, then the last entry would be of value 15.
To check if the string is repeating itself, we just need the last entry to be non-zero and str.size() to divide (str.size()-last entry).
The one-bit array maintained by dp [i] indicates the number of characters in the repeated string up to position i-1, 
excluding the string that is repeated. What is the meaning of this, for example, "abcabc"? Dp array is [0 0 0 0 1 2 3], 
dp array length is one more than the original string length. 
Then we look at the last position of the number 3, it means that the number of repeated string of three characters. 
If it is "abcabcabc", then dp array [0 0 0 0 1 2 3 4 5 6], we find that the last number is 6, then that the string is "abcabc", 
6 characters. So how the last number to know whether the original string is composed of repeated substrings, first of all, 
of course, is the last number can not be 0, but also to meet dp [n]% (n - dp [n]) = = 0, 
because n - dp [n] is the length of a substring, the length of the repeated string is definitely an integer multiple of a substring,
*/

public class Solution {
    public boolean repeatedSubstringPattern(String str) {
        int n = str.length(), i = 1, j = 0; 
        int[] dp = new int[n+1];
        dp[0] = 0;
        char [] s = str.toCharArray();
        while( i<n ) {
            if( s[i] == s[j] ) {
                dp[++i]=++j;
            }
            else if( j == 0 ) 
                i++;
            else 
                j = dp[j];
        }
        return (dp[n] >0  && dp[n]%(n-dp[n])==0);
    }
}
