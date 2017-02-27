/**
You rank players in the game from highest to lowest score. So far you're using an algorithm that sorts in O(n\lg{n})O(nlgn) time, but players are complaining that their rankings aren't updated fast enough. You need a faster sorting algorithm.

Write a function that takes:

an array of unsortedScores
the highestPossibleScore in the game
and returns a sorted array of scores in less than O(n\lg{n})O(nlgn) time.

For example:

  int[] unsortedScores = {37, 89, 41, 65, 91, 53};
final int HIGHEST_POSSIBLE_SCORE = 100;

int[] sortedScores = sortScores(unsortedScores, HIGHEST_POSSIBLE_SCORE);
// sortedScores: [37, 41, 53, 65, 89, 91]

Time - O(n)
Space - O(n)

*/

public int[] sortScores(int[] unorderedScores, int highestPossibleScore) {

    // array of 0s at indices 0..highestPossibleScore
    int[] scoreCounts = new int[highestPossibleScore + 1];

    // populate scoreCounts
    for (int score : unorderedScores) {
        scoreCounts[score]++;
    }

    // populate the final sorted array
    int[] sortedScores = new int[unorderedScores.length];
    int currentSortedIndex = 0;

    // for each item in scoreCounts
    for (int score = 0; score <= highestPossibleScore; score++) {
        int count = scoreCounts[score];

        // for the number of times the item occurs
        for (int occurrence = 0; occurrence < count; occurrence++) {

            // add it to the sorted array
            sortedScores[currentSortedIndex] = score;
            currentSortedIndex++;
        }
    }

    return sortedScores;
}

/*
Bonus:
We chose to generate and return a separate, sorted array. 
Could we instead sort the array in place?  - In-place quick sort or radix sort ?
Does this change the time complexity? The space complexity?
*/
