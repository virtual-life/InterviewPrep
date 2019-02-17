
/*

Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?

Algorithm:

If instead we iterate through the string in reverse, then we will know how many backspace characters we have seen, 
and therefore whether the result includes our character.

Iterate through the string in reverse. If we see a backspace character, the next non-backspace character is skipped. 
If a character isn't skipped, it is part of the final answer.

Time - O(m +n )
Space - O(1)

// Other approach is to use stack which takes O(m+n) time and space 

*/

class Solution {
    public boolean backspaceCompare(String S, String T) {
        int s = S.length() - 1, t = T.length() - 1;

        // start to compare string from the end
        while (s >= 0 && t >= 0) {
            s = nextNonSkipChar(S, s);
            t = nextNonSkipChar(T, t);

            // in case any of two string is already exhausted
            if (s < 0 || t < 0) break;
            // compare two characters
            if (S.charAt(s) != T.charAt(t)) {
              s--;
              t--;
              return false;
            }
            
        }

        // if any of two string is not exhausted yet,
        // check to see if it can be exhausted
        if (s >= 0) s = nextNonSkipChar(S, s);
        if (t >= 0) t = nextNonSkipChar(T, t);

        // check two see if both string has been exhausted
        return s < 0 && t < 0;
    }

    /*
    helper method to find the next unskippable character in the string and return
    its index. Return -1 if the string is exhausted.
     */
    private int nextNonSkipChar(String str, int s) {
        int skip = 0;
        while (s >= 0) {
            // if current char is #, we need to skip next character
            if (str.charAt(s) == '#') {
                skip++;
                s--;
            }
            // if current character is not #, but we still have some characters
            // need to be skipped
            else if (skip > 0) {
                skip--;
                s--;
            }
            // in case this is the character we cannot skip
            else break;
        }
        return s;
    }
}
