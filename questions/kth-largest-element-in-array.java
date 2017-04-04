import java.util.PriorityQueue;

/**
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

 For example,
 Given [3,2,1,5,6,4] and k = 2, return 5.

 Time -  O(log(k)).
 Space -  O(k) for storing the top k numbers.
 */

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for(int i: nums){
            q.offer(i);

            if(q.size()>k){
                q.poll();
            }
        }

        return q.peek();
    }
}

/**
Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.

Time - O(n)
Space - O(k) 
*/

public class Solution {
    public int thirdMax(int[] nums) {
        int k = 3;
        if(nums.length < 3){
            k = 1;
        }
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for(int i: nums){
            if(!q.contains(i)){
                q.offer(i);
            }
            
            if(q.size()>k){
                q.poll();
            }
        }
        // if kth max doesnt exist return max
        if(q.size() < nums.length && q.size() < k){
            while(q.size() > 1){
                q.poll();
            }
        }

        return q.peek();
    }
    
}
