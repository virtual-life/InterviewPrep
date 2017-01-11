public class Solution extends Relation {
    public int findCelebrity(int n) {
        if (n <= 1) return n;
        int cur = 0;
        for (int i = 1; i < n; i ++) {
            if (!knows(i, cur)) cur = i;
        }
        for (int i = 0; i < n; i ++) {
            if (i == cur) continue;
            if (knows(cur, i) || !knows(i, cur)) return -1;
        }
        return cur;
    }
}
