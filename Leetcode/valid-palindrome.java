/**
 Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.
 */


public class Solution {
    public boolean isPalindrome(String s) {
        if(s==null) return false;

        if(s.length()==0) return true;

        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println(s);

        for(int i = 0; i < s.length() ; i++){
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }

        return true;

    }
}