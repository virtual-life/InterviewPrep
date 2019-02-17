/**

Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. There is no limit on how many times a digit can be reused.

You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.

Example 1:

Input: "19:34"
Output: "19:39"
Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  It is not 19:33, because this occurs 23 hours and 59 minutes later.

Example 2:

Input: "23:59"
Output: "22:22"
Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.

Simulate the clock going forward by one minute. Each time it moves forward, if all the digits are allowed, then return the current time.

The natural way to represent the time is as an integer t in the range 0 <= t < 24 * 60. 
Then the hours are t / 60, the minutes are t % 60, and each digit of the hours and minutes can be found by hours / 10, hours % 10 etc.

*/

// Time Complexity: O(1). We try up to 24 * 60 possible times until we find the correct time.
// Space Complexity: O (1) 


public String nextClosestTime(String time) {
        int n=time.length();
        char[]res=time.toCharArray();
        TreeSet<Integer> set=new TreeSet<>();
        // Add the elements into the treeset
        for(char c:res){
            if(c!=':'){
               set.add(c-'0');
            } 
        }
        for(int i=n-1;i>=0;i--){
            char c=time.charAt(i);
            int curDigit=c-'0';
            if(c==':'){
                continue;
            }
            Integer ceil = set.ceiling(curDigit+1); // returns the least element in this set greater than or equal to the given element or null
            
            if(ceil==null||(i==3&&ceil>5)||(i==0&&ceil>2)||(res[0]=='2'&&i==1&&ceil>4)){
                res[i]=(char)(set.first()+'0'); // gets the smalles element in the set 
            }
            
            else{
                res[i]=(char)(ceil+'0');
                return String.valueOf(res);
            }
        }
        return String.valueOf(res);
    }


class Solution {
    public String nextClosestTime(String time) {
        int cur = 60 * Integer.parseInt(time.substring(0, 2));
        cur += Integer.parseInt(time.substring(3));
        Set<Integer> allowed = new HashSet();
        for (char c: time.toCharArray()) if (c != ':') {
            allowed.add(c - '0');
        }

        while (true) {
            cur = (cur + 1) % (24 * 60);
            int[] digits = new int[]{cur / 60 / 10, cur / 60 % 10, cur % 60 / 10, cur % 60 % 10};
            search : {
                for (int d: digits){ 
                    if (!allowed.contains(d)) 
                        break search;
                 }   
                return String.format("%02d:%02d", cur / 60, cur % 60);
            }
        }
    }
}
