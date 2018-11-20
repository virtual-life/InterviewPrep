/*

We have an array of integers, where:

The integers are in the range 1..n1..n
The array has a length of n+1n+1
It follows that our array has at least one integer which appears at least twice. 
But it may have several duplicates, and each duplicate may appear more than twice.

Time - O(NLogN) - Binary search 
Space - O(1)

Our approach is similar to a binary search, except we divide the range of possible answers in half at each step, 
rather than dividing the array in half.

1. Find the number of integers in our input array which lie within the range 1.... n/2

2. Compare that to the number of possible unique integers in the same range.

3. If the number of actual integers is greater than the number of possible integers, 
we know there’s a duplicate in the range 1..n/2, so we iteratively use the same approach on that range.

4. If the number of actual integers is not greater than the number of possible integers, 
we know there must be duplicate in the range n/2 + 1..n , so we iteratively use the same approach on that range.
At some point, our range will contain just 1 integer, which will be our answer.

*/

  public static int findRepeat(int[] theArray) {

    int floor = 1;
    int ceiling = theArray.length - 1;

    while (floor < ceiling) {

        // divide our range 1..n into an upper range and lower range(such that they don't overlap)
        // lower range is floor..midpoint
        // upper range is midpoint+1..ceiling
        
        int midpoint = floor + ((ceiling - floor) / 2);
        int lowerRangeFloor   = floor;
        int lowerRangeCeiling = midpoint;
        int upperRangeFloor   = midpoint + 1;
        int upperRangeCeiling = ceiling;

        // count number of items in lower range
        int itemsInLowerRange = 0;
        for (int item : theArray) {

            // is it in the lower range?
            if (item >= lowerRangeFloor && item <= lowerRangeCeiling) {
                itemsInLowerRange += 1;
            }
        }

        int distinctPossibleIntegersInLowerRange = lowerRangeCeiling - lowerRangeFloor + 1;

        if (itemsInLowerRange > distinctPossibleIntegersInLowerRange) {

            // there must be a duplicate in the lower range
            // so use the same approach iteratively on that range
            floor   = lowerRangeFloor;
            ceiling = lowerRangeCeiling;
        } else {

            // there must be a duplicate in the upper range
            // so use the same approach iteratively on that range
            floor   = upperRangeFloor;
            ceiling = upperRangeCeiling;
        }
    }

    // floor and ceiling have converged
    // we found a number that repeats!
    return floor;
}
