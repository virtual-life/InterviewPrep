public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return 0.f;
        }

        int n1 = nums1.length;
        int n2 = nums2.length;

        /** Odd number of elements */
        if ((n1 + n2) % 2 == 1) {
            return findMedianHelper(nums1, nums2, (n1 + n2) / 2 + 1, 0, n1-1, 0, n2-1);
        }
        /** Even number of elements */
        else {
            double r1 = findMedianHelper(nums1, nums2, (n1 + n2) / 2, 0, n1-1, 0, n2-1);
            double r2 = findMedianHelper(nums1, nums2, (n1 + n2) / 2 + 1, 0, n1-1, 0, n2-1);
            return ( r1 + r2 ) / 2;
        }
    }

    private double findMedianHelper(int[] A, int[] B, int k, int aStart, int aEnd, int bStart, int  bEnd) {
        
        int aLen = aEnd - aStart + 1;
	    int bLen = bEnd - bStart + 1;
	
	
        if (aLen == 0) {
            return B[k - 1];
        }

        if (bLen == 0) {
            return A[k - 1];
        }

        if (k == 1) {
            return Math.min(A[0], B[0]);
        }
        
         /**
         *
         For G to be the overall median (M), it must be less than or equal to 4 elements, within the overall sorted array C.Two of these 4 elements come from array A, which implies that the rest of the elements (two more) must come from array B. 
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
