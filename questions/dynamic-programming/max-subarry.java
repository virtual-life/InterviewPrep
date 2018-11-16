/**
 Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 
 Time - O(n)
 */


public class Solution {
    public int maxSubArray(int[] A) {
        int max = A[0];
        int[] sum = new int[A.length];
        sum[0] = A[0];

        for (int i = 1; i < A.length; i++) {
            sum[i] = Math.max(A[i], sum[i - 1] + A[i]);
            max = Math.max(max, sum[i]);
        }

        return max;
    }

    /** O(1) Space */
    
    // We  ignore the sum of the previous n-1 elements if nth element is greater than the sum - this is to handle negative numbers

    public int maxSubArrayNoSpace(int[] A) {
        int newsum=A[0];
        int max=A[0];
        for(int i=1;i<A.length;i++){
            newsum=Math.max(newsum+A[i],A[i]);
            max= Math.max(max, newsum);
        }
        return max;
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
       
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int startIndex=0;
        int length=0;
      
        for (int i = 0; i < nums.length; i++) {             
            sum = sum + nums[i]; 
            
            if (sum > maxSum){
                maxSum = sum;
                length++;
            } 
            
            if (sum < 0) {
                sum = 0; 
                startIndex = i+1;
                length =1;
                
            }            
               
        } 
        System.out.println("StartIndex "+ startIndex);
        System.out.println("Length "+ length);
        return maxSum; 
        
    }    
}
