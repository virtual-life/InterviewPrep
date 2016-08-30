/**
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.


*/

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2)
		return nums.length;
 
	int j = 0;  // j=1
	int i = 1;  // if duplicates are alllowed atmost twice i = 2
 
	while (i < nums.length) {
		if (nums[i] == nums[j]) {  // if duplicates are alllowed atmost twice if (nums[i] == nums[j] && nums[i] == nums[j-1])
			i++;
		} else {
			j++;
			nums[j] = nums[i];
			i++;
		}
	}
 // this is to do it in-place
	 System.arraycopy(nums,0,nums,0, j + 1);
 
	return j+1;
    }
}
