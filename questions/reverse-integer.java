/**
 *
 * Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321


 If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

 Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

 For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.


 */

public class Solution {
    public int reverse(int x) {
        if (x < 10 && x > -10)
            return x;
        long result = 0;
        boolean neg = false;

        // consider the negative case
        if (x < 0) {
            neg = true;
            x= -x;
        }

        // parse the integer into digits and store into
        while (x > 0) {
            int digit = x % 10;
            x = x / 10;

            result = result * 10 + digit;
        }

        if (neg) result = -result;

        // handle the overflow issue
        if (result > Integer.MAX_VALUE) return 0;
        if (result < Integer.MIN_VALUE) return 0;

        return (int) result;
    }
}