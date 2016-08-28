/**

 Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

 For example,
 Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

 Window position                Max
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 Therefore, return the max sliding window as [3,3,5,5,6,7].

 Note:
 You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

 Follow up:
 Could you solve it in linear time?

 The double-ended queue is the perfect data structure for this problem. It supports insertion/deletion from the front and back.
 The trick is to find a way such that the largest element in the window would always appear in the front of the queue.

 Time - O(n) - This is because each element in the list is being inserted and then removed at most once. Therefore, the total number of insert + delete operations is 2n.

 */

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        Deque<Integer> deque = new LinkedList<Integer>();
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.getLast()]) {
                deque.removeLast();
            }

            deque.addLast(i);

            System.out.println(deque);
            // Remove if the size of the deque is greater than k
            if (i - deque.getFirst() + 1 > k) {
                deque.removeFirst();
            }

            // Add into the result
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[deque.getFirst()];
            }
        }

        return result;
    }
}
