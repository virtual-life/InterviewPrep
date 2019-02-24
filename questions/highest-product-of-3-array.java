/*

Given an arrayOfInts, find the highestProduct you can get from three of the integers.
The input arrayOfInts will always have at least three integers.

Time - O(n)
Space - O(1)

*/

public int highestProductOf3(int[] arrayOfInts) {
    if (arrayOfInts.length < 3) {
        throw new IllegalArgumentException("Less than 3 items!");
    }

    // We're going to start at the 3rd item (at index 2)
    // so pre-populate highests and lowests based on the first 2 items.
    // we could also start these as null and check below if they're set
    // but this is arguably cleaner
    int highest = Math.max(arrayOfInts[0], arrayOfInts[1]);
    int lowest  = Math.min(arrayOfInts[0], arrayOfInts[1]);

    int highestProductOf2 = arrayOfInts[0] * arrayOfInts[1];
    int lowestProductOf2  = arrayOfInts[0] * arrayOfInts[1];

    // except this one--we pre-populate it for the first /3/ items.
    // this means in our first pass it'll check against itself, which is fine.
    int highestProductOf3 = arrayOfInts[0] * arrayOfInts[1] * arrayOfInts[2];

    // walk through items, starting at index 2
    for (int i = 2; i < arrayOfInts.length; i++) {
        int current = arrayOfInts[i];

        // do we have a new highest product of 3?
        // it's either the current highest,
        // or the current times the highest product of two
        // or the current times the lowest product of two
        highestProductOf3 = Math.max(Math.max(
            highestProductOf3,
            current * highestProductOf2),
            current * lowestProductOf2);

        // do we have a new highest product of two?
        highestProductOf2 = Math.max(Math.max(
            highestProductOf2,
            current * highest),
            current * lowest);

        // do we have a new lowest product of two?
        lowestProductOf2 = Math.min(Math.min(
            lowestProductOf2,
            current * highest),
            current * lowest);

        // do we have a new highest?
        highest = Math.max(highest, current);

        // do we have a new lowest?
        lowest = Math.min(lowest, current);
    }

    return highestProductOf3;
}

/*
Bonus
What if we wanted the highest product of 4 items?
What if we wanted the highest product of k items?   - http://www.geeksforgeeks.org/largest-product-subarray-size-k/
If our highest product is really big, it could overflow ↴ . How should we protect against this? - BigInteger or Long 
*/


 // Function returns maximum product of a subarray 
    // of size k in given arrar, arr[0..n-1]. This function 
    // assumes that k is smaller than or equal to n. 
    static int findMaxProduct(int arr[], int n, int k) 
    { 
        // Initialize the MaxProduct to 1, as all elements 
        // in the array are positive 
        int maxProduct = 1; 
        for (int i=0; i<k; i++) 
            maxProduct *= arr[i]; 
   
        int prev_product = maxProduct; 
   
        // Consider every product beginning with arr[i] 
        // where i varies from 1 to n-k-1 
        for (int i=1; i<=n-k; i++) 
        { 
            int curr_product = (prev_product/arr[i-1]) * arr[i+k-1]; 
            maxProduct = Math.max(maxProduct, curr_product); 
            prev_product = curr_product; 
        } 
   
        // Return the maximum product found 
        return maxProduct; 
    } 
