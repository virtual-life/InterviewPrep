/**
Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True.

Time - O(n)
Space - O(n)
*/


public class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
         
        Map<Character, Integer> map = new HashMap<Character, Integer>();
         
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
             
            if (map.containsKey(letter)) {
                int count = map.get(letter) + 1;
                map.put(letter, count);
            } else {
                map.put(letter, 1);
            }
        }
         
        int tolerance = 0;
        
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue() % 2!= 0){
                tolerance++;
            }    
        }    
         
        if (s.length() % 2 == 0) {
            return tolerance == 0;
        } else {
            return tolerance == 1;
        }
    }
}
