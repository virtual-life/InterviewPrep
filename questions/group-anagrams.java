/**

 Given an array of strings, group anagrams together.

 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:

 [
    ["ate", "eat","tea"],
    ["nat","tan"],
    ["bat"]
 ]

 Note:
 For the return value, each inner list's elements must follow the lexicographic order.
 All inputs will be in lower-case.

 Time - O(n) + O(nlogn) for sorting

 */

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();

        for(int i = 0; i < strs.length; i++) {
            char[] strChar = strs[i].toCharArray();
            Arrays.sort(strChar);
            String str = new String(strChar);
            if(map.containsKey(str)) {
                map.get(str).add(strs[i]);
            }
            else {
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(str, list);
            }
        }

        for(List<String> val : map.values()) {
            Collections.sort(val,new ListComparator());
            result.add(val);
        }

        return result;
    }
}

class ListComparator implements Comparator<String>{
    public int compare(String s1, String s2) {
        return s1.compareTo(s2);
    }
}