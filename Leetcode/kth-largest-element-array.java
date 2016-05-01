/**

 Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
 not the kth distinct element.

 For example,
 Given [3,2,1,5,6,4] and k = 2, return 5.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ array's length.

 Time - O(logn) - heapify

 */


public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10,Collections.reverseOrder());
        for(int i=0;i<nums.length;i++){
            pq.offer(nums[i]);
        }
        int n = -1;
        while(k >0){
            n = pq.poll();
            k --;
        }

        return n;
    }
}