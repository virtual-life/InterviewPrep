/**
 Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.


 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

 Assuming the average number of letters on every number is m, and the length of digits string is n

 Time -  O(m^n)

 */

public class Solution {
    public List<String> letterCombinations(String digits) {

        ArrayList<String> result = new ArrayList<String>();
        if(digits == null || digits.length() < 1){
            return result;
        }

        HashMap<Character, String> map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        map.put('0', "");

        StringBuilder b = new StringBuilder();
        dfs(digits, 0, b, map, result);
        return result;
    }

    private void dfs(String digits, int index, StringBuilder b,  HashMap<Character, String> map,  List<String> result) {
        if (digits.length() == index) {
            result.add(b.toString());
            return;
        }
        Character curr = digits.charAt(index);
        String s = map.get(curr);
        for (int i = 0; i < s.length(); i++) {
            b.append(s.charAt(i));
            dfs(digits, index + 1, b, map,result);
            b.deleteCharAt(b.length() - 1);
        }
    }
}