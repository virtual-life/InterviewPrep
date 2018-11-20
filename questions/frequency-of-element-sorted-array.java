/*
Given a sorted array containing duplicates find frequency of each element without traversng the full array 

Time - O(mLogn)
m - number of distinct elements 
modified binary search 

*/


import java.util.HashMap;
import java.util.Map;

class Solution{

	public static void findFrequency(int[] A, int left, int right, Map<Integer, Integer> freq){
  
		if (left > right) {
			return;
		}

		// if every element in the sub-array A[left..right] is equal,
		// then increment the element count by n
		if (A[left] == A[right])
		{
			Integer count = freq.get(A[left]);
			if (count == null) {
				count = 0;
			}

			freq.put(A[left], count + (right - left + 1));
			return;
		}

		int mid = (left + right)/2;

		// divide array into left and right sub-array and recurse
		findFrequency(A, left, mid, freq);
		findFrequency(A, mid + 1, right, freq);
	}

	public static void main(String[] args){
  
		int[] A = { 2, 2, 2, 4, 4, 4, 5, 5, 6, 8, 8, 9 };

		// find frequency of each element of the array and store it in map
		Map<Integer, Integer> freq = new HashMap<>();
		findFrequency(A, 0, A.length - 1, freq);

		System.out.println(freq);
	}
}
