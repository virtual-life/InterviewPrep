/**

 Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".

 Time -  O(n^2).
 Space -  O(n) since we used the status array.

 */

import java.util.Set;

/**
 dp[i] is true means [0, i) is segmented using the dictionary.
 So s[0, i) can be segmented if and only if s[0, j) can be segmented AND s[j, i) is in the dictionary.

 */

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.isEmpty()) return true;

        // dp[i] means [0,i) is breakable
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    
/**
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

 Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"]

*/
public List<String> wordBreak2(String s, Set<String> dict) {
        List<String> result = new ArrayList<String>();
         
        if (s == null || s.length() == 0 || dict == null || dict.size() == 0) {
            return result;
        }
         
        List<String> curr = new ArrayList<String>();
        wordBreakHelper(0, s, dict, curr, result);
         
        return result;
    }
     
    private void wordBreakHelper(int start, String s, Set<String> dict, List<String> curr, List<String> result) {
        if (start >= s.length()) {
            String temp = constructString(curr);
            result.add(temp);
        }
         
        for (int i = start; i < s.length(); i++) {
            if (dict.contains(s.substring(start, i + 1))) {
                curr.add(s.substring(start, i + 1));
                wordBreakHelper(i + 1, s, dict, curr, result);
                curr.remove(curr.size() - 1);
            }
        }
    }
     
    private String constructString(List<String> tokens) {
        StringBuilder sb = new StringBuilder();
         
        for (int i = 0; i < tokens.size() - 1; i++) {
            sb.append(tokens.get(i) + " ");
        }
         
        sb.append(tokens.get(tokens.size() - 1));
         
        return sb.toString();
    }
}
