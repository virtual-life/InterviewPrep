/**
I suspect the online poker game I'm playing shuffles cards by doing a single " riffle ↴ ."

To prove this, let's write a function to tell us if a full deck of cards shuffledDeck is a single riffle of two other halves half1 and half2.

We'll represent a stack of cards as an array of integers in the range 1..521..52 (since there are 5252 distinct cards in a deck).

Time - O(n)
Space - O(1)

*/


public boolean isSingleRiffle(int[] half1, int[] half2, int[] shuffledDeck) {
    int half1Index = 0;
    int half2Index = 0;

    for (int card : shuffledDeck) {
        // if we still have cards in half1
        // and the "top" card in half1 is the same
        // as the top card in shuffledDeck
        if (half1Index < half1.length
                && card == half1[half1Index]) {
            half1Index++;

        // if we still have cards in half2
        // and the "top" card in half2 is the same
        // as the top card in shuffledDeck
        } else if (half2Index < half2.length
                && card == half2[half2Index]) {
            half2Index++;

        // if the top card in shuffledDeck doesn't match the top
        // card in half1 or half2, this isn't a single riffle.
        } else {
            return false;
        }
    }

    // all cards in shuffledDeck have been "accounted for"
    // so this is a single riffle!
    return true;
}
