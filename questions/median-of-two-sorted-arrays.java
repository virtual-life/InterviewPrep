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
 
 The problem is equivalent to find the kth element in the two sorted array.
 */

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return 0.f;
        }

        int n1 = nums1.length;
        int n2 = nums2.length;

        /** Odd number of elements */
        if ((n1 + n2) % 2 == 1) {
            return findMedianHelper(nums1, nums2, (n1 + n2) / 2 + 1);
        }
        /** Even number of elements */
        else {
            double r1 = findMedianHelper(nums1, nums2, (n1 + n2) / 2);
            double r2 = findMedianHelper(nums1, nums2, (n1 + n2) / 2 + 1);
            return ( r1 + r2 ) / 2;
        }
    }

    private double findMedianHelper(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums1.length == 0) {
            return nums2[k - 1];
        }

        if (nums2 == null || nums2.length == 0) {
            return nums1[k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[0], nums2[0]);
        }

        int n1mid = nums1.length/2;
        int n2mid = nums2.length/2;

        /** Median of nums1 & nums2 */
        int m1 = nums1[n1mid];
        int m2 =  nums2[n2mid];

        /**
         *
         If m1 is greater than m2, then median is present in one of the below two subarrays.
         From first element of ar1 to m1 (ar1[0...|_n/2_|])
         From m2 to last element of ar2 (ar2[|_n/2_|...n-1])
         *
         */
        if (m1 > m2) {
            if ((n1mid + n2mid + 1) >= k) {
                return findMedianHelper(Arrays.copyOfRange(nums1, 0, n1mid), nums2, k);
            } else {
                return findMedianHelper(nums1, Arrays.copyOfRange(nums2, n2mid+1, nums2.length), k - (n2mid + 1));
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
                return findMedianHelper(nums1, Arrays.copyOfRange(nums2, 0, n2mid), k);
            } else {
                return findMedianHelper(Arrays.copyOfRange(nums1, n1mid + 1, nums1.length), nums2, k - (n1mid + 1));
            }
        }
    }
}
