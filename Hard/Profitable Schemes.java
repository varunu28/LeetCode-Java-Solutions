class Solution {
    
    private static final int MOD = 1000_000_007;
    
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        Integer[][][] dp = new Integer[101][101][101];
        return helper(0, 0, 0, n, minProfit, group, profit, dp);
    }
    
    private int helper(int pos, int count, int profit, int n, int minProfit, int[] group, int[] profits, Integer[][][] dp) {
        if (pos == group.length) {
            return profit >= minProfit ? 1 : 0;
        }
        if (dp[pos][count][profit] != null) {
            return dp[pos][count][profit];
        }
        int totalWays = helper(pos + 1, count, profit, n, minProfit, group, profits, dp);
        if (count + group[pos] <= n) {
            totalWays += helper(pos + 1, count + group[pos], Math.min(minProfit, profit + profits[pos]), n, minProfit, group, profits, dp);
        }
        return dp[pos][count][profit] = totalWays % MOD;
    }
}
