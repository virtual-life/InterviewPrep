/**
Given a string, find the length of the longest substring T that contains at most k distinct characters.

For example, Given s = “eceba” and k = 2,

T is "ece" which its length is 3.

Time - O(n) Space O(k)

Hashmap is used to track the unique elements in the map. 
When a k+1th unique character is added to the map, the left pointer needs to move right.
*/

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
    int max=0;
    HashMap<Character,Integer> map = new HashMap<Character, Integer>();
    int start=0;
 
    for(int end=0; end<s.length(); end++){
        char c = s.charAt(end);
        if(map.containsKey(c)){
            map.put(c, map.get(c)+1);
        }else{
            map.put(c,1);
        }
 
        if(map.size()>k){
            max = Math.max(max, end-start);
 
            while(map.size()>k){
                char t = s.charAt(start);
                int count = map.get(t);
                if(count>1){
                    map.put(t, count-1);
                }else{
                    map.remove(t);
                }
                start++;
            }
        }
    }
 
    max = Math.max(max, s.length()-start);
 
    return max;
        
    }
}

