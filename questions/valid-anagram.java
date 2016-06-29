import java.util.Arrays;
import java.util.HashMap;

/**

 Given two strings s and t, write a function to determine if t is an anagram of s.

 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.

 Note:
 You may assume the string contains only lowercase alphabets.

 Follow up:
 What if the inputs contain unicode characters? How would you adapt your solution to such case?

 */

public class Solution {
    /**
     *
     Time complexity : O(n \log n)O(nlogn). Assume that nn is the length of ss, sorting costs O(n \log n)O(nlogn)
     and comparing two strings costs O(n)O(n). Sorting time dominates and the overall time complexity is O(n \log n)O(nlogn).

     Space complexity : O(1)O(1). Space depends on the sorting implementation which, usually,
     costs O(1)O(1) auxiliary space if heapsort is used. Note that in Java, toCharArray()
     makes a copy of the string so it costs O(n)O(n) extra space, but we ignore this for complexity analysis because:

     It is a language dependent detail.
     It depends on how the function is designed. For example, the function parameter types can be changed to char[].

     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    /**
     Time complexity : O(n)O(n). Time complexity is O(n)O(n) because accessing the counter table is a constant time operation.

     Space complexity : O(1)O(1). Although we do use extra space, the space complexity is O(1)O(1) because the table's size stays constant no matter how large nn is.
     */

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i), 1);
            }
        }
        for(int i = 0; i < t.length(); i++){
            if(map.containsKey(t.charAt(i))){
                map.put(t.charAt(i), map.get(t.charAt(i))-1);
            }
        }
        for (Integer count : map.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}