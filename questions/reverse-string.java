/**
Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".

Time - O(n)
toCHarArray() is O(n)
*/


public class Solution {
    public String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
         
        char[] cs = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
         
        while (start < end) {
            swap(cs, start, end);
            start++;
            end--;
        }
         
        return new String(cs);
    }
     
    private void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}

//Using recursion

public class Solution {
    public String reverseString(String s) {
        int length = s.length();
        if (length <= 1) return s;
        String leftStr = s.substring(0, length / 2);
        String rightStr = s.substring(length / 2, length);
        return reverseString(rightStr) + reverseString(leftStr);
    }
}
