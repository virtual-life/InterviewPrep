/*
Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:

Input: 2.00000, 10
Output: 1024.00000
Example 2:

Input: 2.10000, 3
Output: 9.26100
Example 3:

Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
Note:

-100.0 < x < 100.0
n is a 32-bit signed integer, within the range [−231, 231 − 1]

https://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/

Time - O(log N )  - Divide and conquer 

*/


public class Solution {
    
  public double myPow(double x, int n) {
	if (n < 0) {
		return 1 / power(x, n);
	} else {
		return power(x, n);
	}
  }

  public double power(double x, int n) {
	if (n == 0)
		return 1;
 
	double v = power(x, n / 2);
	  
	// if instead power(x, n / 2) was calculated every time runtime would be O( N)
	// return power(x, n / 2) * power(x, n / 2)
 
	if (n % 2 == 0) {
		return v * v;
	} else {
		return v * v * x;
	}
   }
	
}
