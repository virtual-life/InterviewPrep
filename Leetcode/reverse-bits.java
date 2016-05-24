/**
 Reverse bits of a given 32 bits unsigned integer.

 For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

 Follow up:
 If this function is called many times, how would you optimize it?

 */

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) | (n & 1);
            n = (n >> 1);
        }

        return result;
    }

    /** Better solution using XOR swap
     *  a function called swapBits(i, j), which swaps the ith bit with the jth bit.
     *  We only need to perform the swap when the ith bit and the jth bit are different.
     *  To test if two bits are different, we could use the XOR operation.
     */

    public int reverseBitsSwap(int n) {
        for (int i = 0; i < 16; i++) {
            n = swapBits(n, i, 32 - i - 1);
        }

        return n;
    }

    public int swapBits(int n, int i, int j) {
        int a = (n >> i) & 1;
        int b = (n >> j) & 1;

        if ((a ^ b) != 0) {
            return n ^= (1 << i) | (1 << j);
        }

        return n;
    }

}