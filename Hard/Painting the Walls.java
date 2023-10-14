class Solution {

    private static final int INVALID_VALUE = 1000_000_000;

    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        Integer[][] dp = new Integer[n][n + 1];
        return compute(0, n, cost, time, dp, n);
    }

    private int compute(int idx, int remain, int[] cost, int[] time, Integer[][] dp, int n) {
        if (remain <= 0) {
            return 0;
        }
        if (idx == n) {
            return INVALID_VALUE;
        }
        if (dp[idx][remain] != null) {
            return dp[idx][remain];
        }
        int paint = cost[idx] + compute(idx + 1, remain - 1 - time[idx], cost, time, dp, n);
        int noPaint = compute(idx + 1, remain, cost, time, dp, n);
        dp[idx][remain] = Math.min(paint, noPaint);
        return dp[idx][remain];
    }
}
