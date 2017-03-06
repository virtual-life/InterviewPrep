/**
Rotate array by number of positions
*/

public class Solution {
	public ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		int n = A.size();
		for (int i = 0; i < n; i++) {
			ret.add(A.get((i + B)% n));
		}
		return ret;

	}
	
}
