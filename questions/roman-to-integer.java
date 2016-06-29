import java.util.HashMap;

/**
 Given a roman numeral, convert it to an integer.
 Input is guaranteed to be within the range from 1 to 3999.

 http://buttercola.blogspot.com/2014/09/leetcode-roman-to-integer.html

 The most challenge part of this problem is to split the string into valid roman numerals. The special case is for 4, 40, 400, and 9, 90, 900. Consider the following string:
 MXXIV. which is 1024. However, it could be wrongly calculated as 1000 + 10 + 10 + 1 + 5 = 1006. To handle this situation, we could scan two characters at a time and check the special case.
 */


public class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;

        // create a hash table to store the dictorary
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i <= s.length() - 2 &&
                    hashMap.get(s.charAt(i)) < hashMap.get(s.charAt(i + 1))) {
                num -= hashMap.get(s.charAt(i));
            } else {
                num += hashMap.get(s.charAt(i));
            }
        }
        return num;
    }
}
