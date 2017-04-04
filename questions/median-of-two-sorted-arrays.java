/**
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays.
 *
 * Time -  O(log (m+n)).
*/

import java.util.Arrays;

/**
 An initial thought was firstly merge the two arrays, then median is  the number on A.length + B.length - 1 / 2.
 However, merging will take O(m + n) time, which however the algorithm asks for a solution in log time.
 So it is naturally to think about the binary search.
 http://buttercola.blogspot.com/2014/09/leetcode-median-of-two-sorted-arrays.html
 
 http://www.drdobbs.com/parallel/finding-the-median-of-two-sorted-arrays/240169222?pgno=2
 
 The problem is equivalent to find the kth element in the two sorted array. -  k is (A's length + B' Length)/2
 */

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return 0.f;
        }

        int n = nums1.length;
        int m = nums2.length;

        /** Odd number of elements */
        if ((n + m) % 2 == 1) {
            return findMedianHelper(nums1, nums2, (n + m) / 2 + 1);
        }
        /** Even number of elements */
        else {
            double r1 = findMedianHelper(nums1, nums2, (n + m) / 2);
            double r2 = findMedianHelper(nums1, nums2, (n + m) / 2 + 1);
            return ( r1 + r2 ) / 2;
        }
    }

    private double findMedianHelper(int[] nums1, int[] nums2, int k) {
        //If nums1 is empty 
        if (nums1 == null || nums1.length == 0) {
            return nums2[k - 1];
        }
        //If nums2 is empty 
        if (nums2 == null || nums2.length == 0) {
            return nums1[k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[0], nums2[0]);
        }

        int mid1 = nums1.length/2;
        int mid2 = nums2.length/2;

        /** Median of nums1 & nums2 */
        int median1 = nums1[mid1];
        int median2 =  nums2[mid2];

        /**
         *
         If median1 is greater than median2, then median is present in one of the below two subarrays.
         From first element of arr1 to median1 (ar1[0...|_n/2_|])
         From median2 to last element of arr2 (ar2[|_n/2_|...n-1])
         *
         */
        if (median1 > median2) {
            if ((mid1 + mid2 + 1) >= k) {
                return findMedianHelper(Arrays.copyOfRange(nums1, 0, mid1), nums2, k);
            } else {
                return findMedianHelper(nums1, Arrays.copyOfRange(nums2, mid2+1, nums2.length), k - (mid2 + 1));
            }
        }
        /**
         *
         If m2 is greater than m1, then median is present in one of the below two subarrays.
         From m1 to last element of ar1 (ar1[|_n/2_|...n-1])
         From first element of ar2 to m2 (ar2[0...|_n/2_|])
         *
         */
        else {
            if ((n1mid + n2mid + 1) >= k) {
                return findMedianHelper(nums1, Arrays.copyOfRange(nums2, 0, mid2), k);
            } else {
                return findMedianHelper(Arrays.copyOfRange(nums1, mid1 + 1, nums1.length), nums2, k - (mid1 + 1));
            }
        }
    }
}
