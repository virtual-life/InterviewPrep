/*
Time - O(n!)
Space - 
*/

// Recursion 

public Set<String> getPermutations(String inputString) {

    Set<String> result = new HashSet<String>();
    // base case
    if (inputString.length() <= 1) {
        return result.add(inputString);
    }

    String allCharsExceptLast = inputString.substring(0, inputString.length() - 1);
    char lastChar = inputString.charAt(inputString.length() - 1);

    // recursive call: get all possible permutations for all chars except last
    Set<String> permutationsOfAllCharsExceptLast = getPermutations(allCharsExceptLast);

    
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
What if our input string had some duplicates? - below code handles that 
*/

public class Solution {
    public List<String> permuteUnique(String inputString) {
        
        List<String> result = new ArrayList<String>();
	    result.add("");
 
	for (int i = 0; i < inputString.length(); i++) {
		Set<String> currentSet = new HashSet<String>();
		
		for (String l : result) {
			for (int j = 0; j < l.size()+1; j++) {			    
				String temp = l.substring(0, j) + inputString.charAt(i) + l.substring(j);
				currentSet.add(temp);				
			}
		}
		result = new ArrayList<String>(currentSet);
	} 
	return result;
    }
}


