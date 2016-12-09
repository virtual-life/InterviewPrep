/**

 Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

 For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.


 Each time we get the least significant bit and check if it is 1. Then shift the number to the right by 1 until 32 times.
 */


public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(long n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1){
                count++;
            }
            // divide by 2 
            n = n >> 1;
        }

        return count;
    }
}
