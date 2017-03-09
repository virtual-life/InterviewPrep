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
