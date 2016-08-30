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
        
  ArrayList<List<Integer>> returnList = new ArrayList<List<Integer>>();
	returnList.add(new ArrayList<Integer>());
 
	for (int i = 0; i < nums.length; i++) {
		Set<ArrayList<Integer>> currentSet = new HashSet<ArrayList<Integer>>();
		for (List<Integer> l : returnList) {
			for (int j = 0; j < l.size() + 1; j++) {
				l.add(j, nums[i]);
				ArrayList<Integer> T = new ArrayList<Integer>(l);
				l.remove(j);
				currentSet.add(T);
			}
		}
		returnList = new ArrayList<List<Integer>>(currentSet);
	}
 
	return returnList;
 }
}
