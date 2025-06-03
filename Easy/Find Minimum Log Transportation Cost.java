class Solution {
    public long minCuttingCost(int n, int m, int k) {
        long cost = 0;
        if (n > k) {
            cost += ((long) (n - k)) * (k);
        }
        if (m > k) {
            cost += ((long) (m - k)) * (k);
        }
        return cost;
    }
}
