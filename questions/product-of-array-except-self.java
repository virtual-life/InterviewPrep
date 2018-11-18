/**
 Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

 Solve it without division and in O(n).

 For example, given [1,2,3,4], return [24,12,8,6].

 a[i], =  a[0] * a[1] * ... * a[i - 1], and a[n - 1] * ... * a[i + 1].
 result[i] = before[i] * after[i]

 Time - O(n)
 Space - O(n)

 */


public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        int[] result = new int[nums.length];
        result[0] = 1;

        // before a[i]
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // after a[i]
        int after = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            result[i] = result[i] * after * nums[i + 1];
            after = after * nums[i + 1];
        }

        return result;
    }
  
 /**
  Time - O(n)
  Space - O(n)
 */
    
    public int[] getProductsOfAllIntsExceptAtIndex(int[] arr) {

    // we make an array with the length of the input array to
    // hold our products
    int[] result = new int[arr.length];

    // for each integer, we find the product of all the integers
    // before it, storing the total product so far each time
    int productSoFar = 1;
    for (int i = 0; i < arr.length; i++) {
        result[i] = productSoFar;
        productSoFar = productSoFar * arr[i];
    }

    // for each integer, we find the product of all the integers
    // after it. since each index in products already has the
    // product of all the integers before it, now we're storing
    // the total product of all other integers
    productSoFar = 1;
    for (int i = arr.length - 1; i >= 0; i--) {
        result[i] =  result[i] * productSoFar;
        productSoFar = productSoFar * arr[i];
    }

    return result;
  }
}
