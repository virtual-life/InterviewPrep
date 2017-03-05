/**
Now I have an array of words that are mostly alphabetical, except they start somewhere in the middle of the alphabet, reach the end, and then start from the beginning of the alphabet. 
In other words, this is an alphabetically ordered array that has been "rotated." For example:

  String[] words = new String[]{
    "ptolemaic",
    "retrograde",
    "supplant",
    "undulate",
    "xenoepist",
    "asymptote", // <-- rotates here!
    "babka",
    "banoffee",
    "engender",
    "karpatka",
    "othellolagkage",
};

Write a function for finding the index of the "rotation point," which is where I started working from the beginning of the dictionary. 
This array is huge (there are lots of words I don't know) so we want to be efficient here.


Time - O(log n)
Space - O(1)

*/

// [ "k","v","a","b","c","d","e","g","i" ]
                      ^
// [ "a","b","c","d","e","f","g","h","i" ]                      

public int findRotationPoint(String[] words) {
    final String firstWord = words[0];

    int low = 0;
    int high = words.length - 1;

    while (low < high) {

        // mid a point halfway between floor and ceiling
        int mid = (low + high) / 2;

        // if mid comes after first word or is the first word
        if (words[mid].compareTo(firstWord) >= 0) {
            // go right
            low = mid;
        } else {
            // go left
            high = mid;
        }

        // if floor and ceiling have converged
        if (low + 1 == high) {
        
             // if array is NOT rotated
             if( words[high].compareTo(words[low] >= 0){
                    return 0;
             }
                
            // between floor and ceiling is where we flipped to the beginning
            // so ceiling is alphabetically first
            break;
        }
    }

    return high;
}


