/**
 There is a garden with N slots. In each slot, there is a flower. The N flowers will bloom one by one in N days. In each day, there will be exactly one flower blooming and it will be in the status of blooming since then.

Given an array flowers consists of number from 1 to N. Each number in the array represents the place where the flower will open in that day.

For example, flowers[i] = x means that the unique flower that blooms at day i will be at position x, where i and x will be in the range from 1 to N.

Also given an integer k, you need to output in which day there exists two flowers in the status of blooming, and also the number of flowers between them is k and these flowers are not blooming.

If there isn't such day, output -1.

Example 1:

Input: 
flowers: [1,3,2]
k: 1
Output: 2
Explanation: In the second day, the first and the third flower have become blooming.

Example 2:

Input: 
flowers: [1,2,3]
k: 1
Output: -1

Note:

    The given array will be in the range [1, 20000].

ots which bloom on day i is flowers[i] -   [ 6, 5, 8, 9, 7, 1, 10, 2, 3, 4] 
Initial configuration of pots   - [  F, F, F, F,  F, F,   F,  F,  F, F]  (F not blooming, T blooming)

indexing starts from 1

day 1 - [  F, F, F, F,  F, T,  F,  F, F, F]  - pot 6 bloomed
day 2 - [  F, F, F, F,  T, T,  F,  F, F, F]  - pot 5 bloomed
day 3 - [  F, F, F, F,  T, T,  F, T,  F, F]  - pot 8 bloomed
day 4 - [  F, F, F, F,  T, T,  F, T,  T, F]  - pot 9 bloomed
day 5 - [  F, F, F, F,  T, T,  T, T,  T, F]  - pot 7 bloomed
day 6 - [  T, F, F, F,  T, T,  T, T,  T, F]  - pot 1 bloomed
day 7 - [  T, F, F, F,  T, T,  T, T,  T, T]  - pot 10 bloomed
day 8 - [  T, T, F, F,  T, T,  T, T,  T, T]  - pot 2 bloomed and   between 2nd and 5th pot  2 (k=2) pots are non blooming, so answer is 8
*/

// O(NlogN), where N is the length of flowers. Every insertion and search is O(log⁡N)

class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> active = new TreeSet();
        int day = 0;
        for (int flower: flowers) {
            day++;
            active.add(flower);
            Integer lower = active.lower(flower)
            Integer higher = active.higher(flower);
            if (lower != null && flower - lower - 1 == k ||
                    higher != null && higher - flower - 1 == k)
                return day;
        }
        return -1;
    }
}

