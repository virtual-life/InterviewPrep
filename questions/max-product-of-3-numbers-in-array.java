/**

Given an array of integers, return the highest product possible by multiplying 3 numbers from the array

Input:

array of integers e.g {1, 2, 3}
NOTE: Solution will fit in a 32-bit signed integer
Example:

[0, -1, 3, 100, 70, 50]

=> 70*50*100 = 350000
*/

public class Solution {
    public int maxp3(ArrayList<Integer> A) {
        
        if (A == null || A.size() < 3)
            return 0;
            
        Collections.sort(A);
        int n = A.size();
        
        int max;
        
        max = A.get(n - 3) * A.get(n - 2) * A.get(n - 1);
        
        max = Math.max(max, A.get(0) * A.get(1) * A.get(n - 1));
        
        return max;
        
    }
}
