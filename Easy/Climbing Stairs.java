class Solution {
    public int climbStairs(int n) {
        Integer[] dp = new Integer[n + 1];
        return climbStairs(dp, n);
    }

    private int climbStairs(Integer[] dp, int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (dp[n] != null) {
            return dp[n];
        }
        return dp[n] = climbStairs(dp, n - 1) + climbStairs(dp, n - 2);
    }
}
