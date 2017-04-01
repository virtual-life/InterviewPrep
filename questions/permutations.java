/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
Time O(n! )
*/

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
	    result.add(new ArrayList<Integer>());
 
	for (int i = 0; i < nums.length; i++) {
		Set<ArrayList<Integer>> currentSet = new HashSet<ArrayList<Integer>>();
		
		for (List<Integer> l : result) {
			for (int j = 0; j < l.size()+1; j++) {			    
				ArrayList<Integer> temp = new ArrayList<Integer>(l);
				temp.add(j, nums[i]);
				currentSet.add(temp);				
			}
		}
		result = new ArrayList<List<Integer>>(currentSet);
	} 
	return result;
    }
}
