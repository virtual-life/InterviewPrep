/*
Time - O(n!)
Space - 
*/

// Recursion 

public Set<String> getPermutations(String inputString) {

    // base case
    if (inputString.length() <= 1) {
        return new HashSet<String>(Arrays.asList(inputString));
    }

    String allCharsExceptLast = inputString.substring(0, inputString.length() - 1);
    char lastChar = inputString.charAt(inputString.length() - 1);

    // recursive call: get all possible permutations for all chars except last
    Set<String> permutationsOfAllCharsExceptLast = getPermutations(allCharsExceptLast);

    
    Set<String> result = new HashSet<String>();
    
    // put the last char in all possible positions for each of the above permutations
    for (String ss : permutationsOfAllCharsExceptLast) {
        for (int position = 0; position <= ss.length(); position++) {
            String permutation = ss.substring(0, position) + lastChar + ss.substring(position);
            result.add(permutation);
        }
    }

    return result;
}


//Iterative 



/*
Bonus
What if our input string had some duplicates?
*/
