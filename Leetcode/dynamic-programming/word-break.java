/**

 Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".

 Time -  O(n^2).
 Space -  O(n) since we used the status array.

 */

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
}