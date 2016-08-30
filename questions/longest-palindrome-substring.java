/**

 Given a string S, find the longest palindromic substring in S.
 You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

 Time O(n^2), Space O(1)
 
 We observe that a palindrome mirrors around its center. 
 Therefore, a palindrome can be expanded from its center, and there are only 2N-1 such centers.

You might be asking why there are 2N-1 but not N centers?
The reason is the center of a palindrome can be in between two letters. Such palindromes have even number of letters (such as “abba”) and its center are between the two ‘b’s.

Since expanding a palindrome around its center could take O(N) time, the overall complexity is O(N2).

 */


public class Solution {
    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return null;
        }

        if (s.length() == 1) {
            return s;
        }

        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length() ; i++) {
            // get longest palindrome with center of i
            //for odd length
            String tmp = helper(s, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }

            // get longest palindrome with center of i, i+1
            //for even length
            tmp = helper(s, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }

        return longest;
    }

    // Given a center, either one letter or two letter,
// Find longest palindrome
    public String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin+1, end);
    }

}
