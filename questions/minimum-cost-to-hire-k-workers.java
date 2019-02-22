/*
There are N workers.  The i-th worker has a quality[i] and a minimum wage expectation wage[i].

Now we want to hire exactly K workers to form a paid group.  When hiring a group of K workers, we must pay them according to the following rules:

Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the paid group.
Every worker in the paid group must be paid at least their minimum wage expectation.
Return the least amount of money needed to form a paid group satisfying the above conditions.

 

Example 1:

Input: quality = [10,20,5], wage = [70,50,30], K = 2
Output: 105.00000
Explanation: We pay 70 to 0-th worker and 35 to 2-th worker.
Example 2:

Input: quality = [3,1,10,10,1], wage = [4,8,2,2,7], K = 3
Output: 30.66667
Explanation: We pay 4 to 0-th worker, 13.33333 to 2-th and 3-th workers seperately. 
 

Note:

1 <= K <= N <= 10000, where N = quality.length = wage.length
1 <= quality[i] <= 10000
1 <= wage[i] <= 10000
Answers within 10^-5 of the correct answer will be considered correct.

*/


/*
http://ryansiroiro.blogspot.com/2018/06/leetcode-857-minimum-cost-to-hire-k.html

Observation 1: Let G the paid group satisfying the above conditions that has the least amount of money. There must be a worker i such that he is paid at the minimum wage.  To prove it, we can reason by contradiction. If that is not the case, then we can always find a scaling factor λ such that after we multiply the pay of each worker with λ, at least one of them gets the minimum payment.

Observation 2: Given the condition 1, only the the total quality and the wage/quality ratio matters.

Observation 3: given the condition 2, only the highest wage/quality ratio in the group matters because otherwise, the wage calculated with other ratio will be less than the minimum wage of the worker that has the highest wage/quality ratio.

Now combine all the observations above, we can come up with the following solution: we first calculate the wage/quality ratio of each worker and sort them in a decreasing order. Then we process each worker one-by-one. We pick the the worker with the highest ratio and add him to the group. If the size of the group is less than K, we need to add more workers to the group. Because we start with the worker with the highest ratio (this is the ratio part in the observation 2), when we add other worker to the group, we just need to select the one that has the minimum quality (this is the total quality part in the observation 2). After we construct the group, we calculate the total cost and update the record of the minimum cost.  Finally, we will remove this worker with the highest ratio from the group and process the worker that has the second largest ratio and we repeat this process.


https://leetcode.com/problems/minimum-cost-to-hire-k-workers/discuss/141768/Detailed-explanation-O(NlogN)

"1. Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the paid group."
So for any two workers in the paid group,
we have wage[i] : wage[j] = quality[i] : quality[j]
So we have wage[i] : quality[i] = wage[j] : quality[j]
We pay wage to every worker in the group with the same ratio compared to his own quality.

"2. Every worker in the paid group must be paid at least their minimum wage expectation."
For every worker, he has an expected ratio of wage compared to his quality.

So to minimize the total wage, we want a small ratio.
So we sort all workers with their expected ratio, and pick up K first worker.
Now we have a minimum possible ratio for K worker and we their total quality.

As we pick up next worker with bigger ratio, we increase the ratio for whole group.
Meanwhile we remove a worker with highest quality so that we keep K workers in the group.
We calculate the current ratio * total quality = total wage for this group.

We redo the process and we can find the minimum total wage.
Because workers are sorted by ratio of wage/quality.
For every ratio, we find the minimum possible total quality of K workers.

Time Complexity
O(NlogN) for sort.
O(NlogK) for priority queue.



Time Complexity: O(NlogN), where N is the number of workers.

Space Complexity: O(N). 
*/


// We'll also maintain sumq, the sum of this heap.



class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int N = quality.length;
        Worker[] workers = new Worker[N];
        for (int i = 0; i < N; ++i)
            workers[i] = new Worker(quality[i], wage[i]);
        Arrays.sort(workers); // Sort by wage/quality ratop 

        double ans = Double.MAX_VALUE;
        int sumq = 0; // maintains total quality 
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (Worker worker: workers) {
         
            pq.offer(-worker.quality); // Maintain a max heap of quality. (We're using a minheap, with negative values.) 
            sumq = sumq + worker.quality;
         
            if (pq.size() > K)
                sumq += pq.poll(); // subtract the quality of teh removed worker 
         
            if (pq.size() == K)
                ans = Math.min(ans, sumq * worker.ratio());
        }

        return ans;
    }
}

class Worker implements Comparable<Worker> {
    public int quality, wage;
    public Worker(int q, int w) {
        quality = q;
        wage = w;
    }

    public double ratio() {
        return (double) wage / quality;
    }

    public int compareTo(Worker other) {
        return Double.compare(ratio(), other.ratio());
    }
}
