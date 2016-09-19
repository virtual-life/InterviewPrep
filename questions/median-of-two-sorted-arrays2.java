public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return 0.f;
        }

        int m = nums1.length;
        int n = nums2.length;

        /** Odd number of elements */
        if ((m + n) % 2 == 1) {
            return findMedianHelper(nums1, nums2, (m + n) / 2 , 0, m-1, 0, n-1);
        }
        /** Even number of elements */
        else {
            double r1 = findMedianHelper(nums1, nums2, (m + n) / 2, 0, m-1, 0, n-1);
            double r2 = findMedianHelper(nums1, nums2, (m + n) / 2 - 1, 0, m-1, 0, n-1);
            return ( r1 + r2 ) / 2;
        }
    }

    private double findMedianHelper(int[] A, int[] B, int k, int aStart, int aEnd, int bStart, int  bEnd) {
        
        int aLen = aEnd - aStart + 1;
	int bLen = bEnd - bStart + 1;
	

	// return kth element
        if (aLen == 0) {
            return B[bStart + k];
        }

        if (bLen == 0) {
            return A[aStart + k];
        }
        
        
        if (k == 0) {
            return Math.min(A[aStart], B[bStart]);
        }
        
         /**
         *
         For G to be the overall median (M), it must be less than or equal to 4 elements, within the overall sorted array C.
         Two of these 4 elements come from array A, which implies that the rest of the elements (two more) must come from array B. 
         *
         */
        // aMid = aLen / 2 and k = （aLen + bLen)/2, so aMid = aLen * k/(aLen + bLen)
        int aMid = aLen * k / (aLen + bLen); // a's middle count

	int bMid = k - aMid - 1; // b's middle count
 
	// make aMid and bMid to be array index
	aMid = aMid + aStart;
	bMid = bMid + bStart;
 
         /**
         *
         If m1 is greater than m2, then median is present in one of the below two subarrays.
         From first element of ar1 to m1 (ar1[0...|_n/2_|])
         From m2 to last element of ar2 (ar2[|_n/2_|...n-1])
         *
         */
	    if (A[aMid] > B[bMid]) {
		    k = k - (bMid - bStart + 1);
		    aEnd = aMid;
		    bStart = bMid + 1;
	    } 
	    /**
         *
         If m2 is greater than m1, then median is present in one of the below two subarrays.
         From m1 to last element of ar1 (ar1[|_n/2_|...n-1])
         From first element of ar2 to m2 (ar2[0...|_n/2_|])
         *
         */
	    else {
		    k = k - (aMid - aStart + 1);
		    bEnd = bMid;
		    aStart = aMid + 1;
	    }

        return findMedianHelper(A, B, k, aStart, aEnd, bStart, bEnd);
    }
}
