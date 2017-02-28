/**
Write a function for doing an in-place ↴ shuffle of an array.
The shuffle must be "uniform," meaning each item in the original array must have the same probability of ending up in each spot in the final array.

Assume that you have a function getRandom(floor, ceiling) for getting a random integer that is >= floor and <= ceiling.

FISHER-YATES ALGO
KNUTH SHUFFLE

Time - O(n)
Space - O(1)

*/

/*
We choose a random item to move to the first index, then we choose a random other item to move to the second index, etc. 
We "place" an item in an index by swapping it with the item currently at that index.
Crucially, once an item is placed at an index it can't be moved. 
So for the first index we choose from nn items, for the second index we choose from n-1n−1 items, etc.

*/

import java.util.Random;

public int getRandom(int floor, int ceiling) {
    Random rand = new Random();
    return rand.nextInt((ceiling - floor) + 1) + floor;
}

public void shuffle(int[] theArray) {
    // if it's 1 or 0 items, just return
    if (theArray.length <= 1) return;

    // walk through from beginning to end
    for (int indexWeAreChoosingFor = 0;
        indexWeAreChoosingFor < theArray.length - 1; indexWeAreChoosingFor++) {

        // choose a random not-yet-placed item to place there
        // (could also be the item currently in that spot)
        // must be an item AFTER the current item, because the stuff
        // before has all already been placed
        int randomChoiceIndex = getRandom(indexWeAreChoosingFor, theArray.length - 1);

        // place our random choice in the spot by swapping
        if (randomChoiceIndex != indexWeAreChoosingFor) {
            int valueAtIndexWeChoseFor = theArray[indexWeAreChoosingFor];
            theArray[indexWeAreChoosingFor] = theArray[randomChoiceIndex];
            theArray[randomChoiceIndex] = valueAtIndexWeChoseFor;
        }
    }
}
