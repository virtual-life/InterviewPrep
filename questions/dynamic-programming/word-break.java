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
    
    public boolean wordBreak1Recursive(String s, Set<String> dict) {
        if (dict.contains(s)) return true;
         
        int len = s.length();
         
        for (int i = 1; i < len; i++) {
            String s1 = s.substring(0, i);
            if (dict.contains(s1)) {
                String s2 = s.substring(i, len);
                if (wordBreak(s2, dict) == true) return true;
            }
        }
        return false;
    }
    
/**
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

 Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"]

*/
public ArrayList<String> wordBreak2(String s, Set<String> dict) {
        ArrayList<String> result = new ArrayList<String>();
        if (s == null || s.isEmpty() || dict.isEmpty()) 
            return result;
         
        wordBreakHelper(s, dict, "", result);
         
        return result;
    }
     
    private void wordBreakHelper(String s, Set<String> dict, String item, ArrayList<String> result) {
        if (!isBreakable(s, dict)) return;
         
        if (s.isEmpty()) {
            result.add(item);
            return;
        }
         
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (dict.contains(sb.toString())) {
                String newItem = item.length() > 0 ? item + " " + sb.toString() : sb.toString();
                wordBreakHelper(s.substring(i + 1), dict, newItem, result);
            }
        }
    }
     
    private boolean isBreakable(String s, Set<String> dict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
         
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] == true && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
         
        return dp[s.length()];
    }
}
