import java.util.HashMap;

/**

 Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

 For example,
 S = "ADOBECODEBANC"
 T = "ABC"
 Minimum window is "BANC".

 Note:
 If there is no such window in S that covers all characters in T, return the empty string "".

 If there is such a window, you are guaranteed that there will always be only one unique minimum window in S.


 Time - O(n)
 */

public class Solution {
    public String minWindow(String s, String t) {

        if(t.length()>s.length())
            return "";

        String result = "";

        //character counter for t
        HashMap<Character, Integer> target = new HashMap<Character, Integer>();
        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            if(target.containsKey(c)){
                target.put(c,target.get(c)+1);
            }else{
                target.put(c,1);
            }
        }

        // character counter for s
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int left = 0;
        int minLen = Integer.MAX_VALUE;

        int count = 0; // the total of mapped characters

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            // skip characters not in T
            if(target.containsKey(c)){
                if(map.containsKey(c)){
                    if(map.get(c)<target.get(c)){
                        count++;
                    }
                    map.put(c,map.get(c)+1);
                }else{
                    map.put(c,1);
                    count++;
                }
            }
            // if window constraint is satisfied
            if(count == t.length()){
                char sc = s.charAt(left);

                // advance begin index as far right as possible, stop when advancing breaks window constraint.

                while (!map.containsKey(sc) || map.get(sc) > target.get(sc)) {
                    if (map.containsKey(sc) && map.get(sc) > target.get(sc))
                        map.put(sc, map.get(sc) - 1);
                    left++;
                    sc = s.charAt(left);
                }
                // update minWindow if a minimum length is met
                //windowLen = end - begin + 1;
                //windowLen < minLen
                if (i - left + 1 < minLen) {
                    result = s.substring(left, i + 1);
                    minLen = i - left + 1;
                }
            }
        }

        return result;

    }
}
