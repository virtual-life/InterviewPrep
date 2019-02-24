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
    public List<List<Integer>> permute(int[] nums) {
     
     List<List<Integer>> result = new ArrayList<List<Integer>>();
 
	//start from an empty list
	result.add(new ArrayList<Integer>());
 
	for (int i = 0; i < nums.length; i++) {
		//list of list in current iteration of the array num
		// Using hasset to get unique permutations 
		Set<ArrayList<Integer>> current = new HashSet<ArrayList<Integer>>();
 
		for (List<Integer> l : result) {
			// # of locations to insert is largest index + 1
			for (int j = 0; j < l.size()+1; j++) {
 
				ArrayList<Integer> temp = new ArrayList<Integer>(l);
				
				// + add num[i] to different locations
				temp.add(j, nums[i]);
				
				current.add(temp);

			}
		}
 
		result = new ArrayList<List<Integer>>(current);
	}
 
	return result;
        
    }
}


/*
   Backtracking approach - similar to DFS 		
*/

public List<List<Integer>> permute(int[] nums) {
   List<List<Integer>> result = new ArrayList<>();
   // Arrays.sort(nums); // not necessary
   backtrack(result, new ArrayList<>(), nums);
   return result;
}

private void backtrack(List<List<Integer>> result, List<Integer> temp, int [] nums){
   if(temp.size() == nums.length){
      result.add(new ArrayList<>(temp));
   } else{
      for(int i = 0; i < nums.length; i++){ 
         if(temp.contains(nums[i])) 
		 continue; // element already exists, skip
         temp.add(nums[i]);
         backtrack(result, temp, nums);
         temp.remove(temp.size() - 1);
      }
   }
} 
