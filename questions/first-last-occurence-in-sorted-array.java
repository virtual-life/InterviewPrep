/*

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

*/


/*
 In normal finary search we return as soon as we find the element, instead to find teh first occurence,
 continue searching towards the left with high = mid-1. 
 
 Similarly for last occurence low = mid+1
 
*/

class Solution  { 

    /* if x is present in arr[] then returns the index of 
    FIRST occurrence of x in arr[0..n-1], otherwise 
    returns -1 */
    public static int first(int arr[], int low, int high, int x, int n) { 
    
        if(low <= high) { 
            int mid = low + (high - low)/2; 
            if( ( mid == 0 || x > arr[mid-1]) && arr[mid] == x) 
                return mid; 
             else if(x > arr[mid]) 
                return first(arr, (mid + 1), high, x, n); 
            else
                return first(arr, low, (mid -1), x, n); 
        } 
       return -1; 
    } 
   
    /* if x is present in arr[] then returns the index of 
    LAST occurrence of x in arr[0..n-1], otherwise 
    returns -1 */
    public static int last(int arr[], int low, int high, int x, int n) { 
    
        if (low <= high) { 
        
            int mid = low + (high - low)/2; 
            if (( mid == n-1 || x < arr[mid+1]) && arr[mid] == x) 
                 return mid; 
            else if (x < arr[mid]) 
                return last(arr, low, (mid -1), x, n); 
            else
                return last(arr, (mid + 1), high, x, n); 
        } 
       return -1; 
    } 
      
    public static void main (String[] args) { 
          
        int arr[] = {1, 2, 2, 2, 2, 3, 4, 7, 8, 8}; 
        int n = arr.length; 
        int x = 8; 
        System.out.println("First Occurrence = " + first(arr, 0, n-1, x, n)); 
        System.out.println("Last Occurrence = " + last(arr, 0, n-1, x, n)); 
  
    } 
} 
