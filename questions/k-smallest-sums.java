/*
You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:

Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]] 
Explanation: The first 3 pairs are returned from the sequence: 
             [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:

Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [1,1],[1,1]
Explanation: The first 2 pairs are returned from the sequence: 
             [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:

Input: nums1 = [1,2], nums2 = [3], k = 3
Output: [1,3],[2,3]
Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]

Time - O(kLogk)
*/



public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
         List<int[]> result = new ArrayList<>();
        if(nums1 == null || nums1.length == 0 || 
                nums2 == null || nums2.length == 0) return result;

       // Pair is used to store the sum, the index in nums1 and the index in nums2.
        class Pair{
            int x;
            int y;
            int sum;
            Pair(int sum, int x, int y){
                this.sum = sum;
                this.x = x;
                this.y =y;
            }
        }   

        Comparator<Pair> comp = new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){
                return p1.sum - p2.sum;
            }
        };

        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(k, comp);
        
        // add the first column
        for (int i=0; i<nums1.length; i++){         
            queue.add(new Pair(nums1[i]+nums2[0], i, 0));
        }
        
        while (k-- > 0 && !queue.isEmpty()){
         
            Pair current = queue.poll();
            result.add(new int[]{nums1[current.x], nums2[current.y]});
            // if the current one has a right candidate, add it to the queue. 
            if (current.y+1 < nums2.length){
                queue.add(new Pair(nums1[current.x]+nums2[current.y+1], current.x, current.y+1));
            }
        }
        
        return result;
        
    }
}
