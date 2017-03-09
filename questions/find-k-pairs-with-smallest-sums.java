/**
You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:
Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

Return: [1,2],[1,4],[1,6]

The first 3 pairs are returned from the sequence:
[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:
Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

Return: [1,1],[1,1]

The first 2 pairs are returned from the sequence:
[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:
Given nums1 = [1,2], nums2 = [3],  k = 3 

Return: [1,3],[2,3]

All possible pairs are returned from the sequence:
[1,3],[2,3]

Time - O(klogk) - since queue.size <= k and we do at most k loop.

*/


public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if(nums1 == null || nums1.length == 0 || 
                nums2 == null || nums2.length == 0) return res;

        class Pair{
            int x;
            int y;
            Pair(int x, int y){
                this.x = x;
                this.y =y;
            }
        }   

        Comparator<Pair> comp = new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){
                return nums1[p1.x] + nums2[p1.y]
                        - nums1[p2.x] - nums2[p2.y];
            }
        };

        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(k, comp);

        boolean[][] visited = new boolean[nums1.length][nums2.length];

        queue.offer(new Pair(0, 0));
        visited[0][0] = true;

        int[][] close = new int[][]{{0,1},{1,0}};
        while(k > 0 && !queue.isEmpty()){
            k--;
            Pair p = queue.poll();
            res.add(new int[]{nums1[p.x], nums2[p.y]});
            for(int i=0; i< 2;i++){
                int tx = p.x + close[i][0];
                int ty = p.y + close[i][1];
                if(tx < nums1.length && ty <nums2.length && !visited[tx][ty]){
                    queue.offer(new Pair(tx, ty));
                    visited[tx][ty] = true;

                }

            }
        }

        return res;
    }
}
