import java.util.HashMap;
import java.util.Map;

/**
 Given a pattern and a string str, find if str follows the same pattern.

 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

 Examples:
 pattern = "abba", str = "dog cat cat dog" should return true.
 pattern = "abba", str = "dog cat cat fish" should return false.
 pattern = "aaaa", str = "dog cat cat dog" should return false.
 pattern = "abba", str = "dog dog dog dog" should return false.
 Notes:
 You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
*/


public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || pattern.length() == 0 || str == null || str.length() == 0) {
            return false;
        }

        String[] tokens = str.split(" ");

        if (pattern.length() != tokens.length) {
            return false;
        }

        Map<String, Character> inverseMap = new HashMap<String, Character>();
        Map<Character, String> map = new HashMap<Character,String>();

        int i = 0;
        for (i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);

            String token = tokens[i];

            // Check the one-one mapping
            if (!map.containsKey(ch) && !inverseMap.containsKey(token)) {
                map.put(ch, token);
                inverseMap.put(token, ch);
            } else if (map.containsKey(ch) && inverseMap.containsKey(token)) {
                String token1 = map.get(ch);
                char ch1 = inverseMap.get(token);

                if (!token1.equals(token) || ch != ch1) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }

    /**
     * Given a pattern and a string str, find if str follows the same pattern.

     Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.

     Examples:
     pattern = "abab", str = "redblueredblue" should return true.
     pattern = "aaaa", str = "asdasdasdasd" should return true.
     pattern = "aabb", str = "xyzabcxzyabc" should return false.
     Notes:
     You may assume both pattern and str contains only lowercase letters.
     */

    public boolean wordPatternMatch(String pattern, String str) {
        if ((pattern == null || pattern.length() == 0) && (str == null || str.length() == 0)) {
            return true;
        }

        if ((pattern == null || pattern.length() == 0) || (str == null || str.length() == 0)) {
            return false;
        }

        Map<Character, String> forwardMap = new HashMap<>();
        Map<String, Character> invertedMap = new HashMap<>();

        return wordPatternMatchHelper(0, pattern, 0, str, forwardMap, invertedMap);
    }

    private boolean wordPatternMatchHelper(int pStart, String pattern,
                                           int sStart, String str,
                                           Map<Character, String> forwardMap,
                                           Map<String, Character> invertedMap) {
        if (pStart == pattern.length() && sStart == str.length()) {
            return true;
        }

        if (pStart >= pattern.length() || sStart >= str.length()) {
            return false;
        }

        char pChar = pattern.charAt(pStart);
        for (int i = sStart; i < str.length(); i++) {
            String curr = str.substring(sStart, i + 1);

            if ((!forwardMap.containsKey(pChar)) && (!invertedMap.containsKey(curr))) {
                forwardMap.put(pChar, curr);
                invertedMap.put(curr, pChar);

                if (wordPatternMatchHelper(pStart + 1, pattern, i + 1,
                        str, forwardMap, invertedMap)) {
                    return true;
                }

                forwardMap.remove(pChar);
                invertedMap.remove(curr);
            } else if (forwardMap.containsKey(pChar) && invertedMap.containsKey(curr)) {
                String dict = forwardMap.get(pChar);
                char pCharDict = invertedMap.get(curr);

                // IMPORTANT !! If not equal, instead of returnning false immedidately,
                // We need to try other longer substrings.
                if (!dict.equals(curr) || pCharDict != pChar) {
                    continue;
                }

                if (wordPatternMatchHelper(pStart + 1, pattern, i + 1, str,
                        forwardMap, invertedMap)) {
                    return true;
                }
            }
        }

        return false;
    }
}
