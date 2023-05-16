class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n][k];
        for (int i = 0; i < k; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                dp[i][j] = minCost(dp[i - 1], j) + costs[i][j];
            }
        }
        return minCost(dp[n - 1], -1);
    }
    
    private int minCost(int[] dp, int currPaintIdx) {
        int cost = Integer.MAX_VALUE;
        int idx = 0;
        while (idx < dp.length) {
            if (!(currPaintIdx != -1 && idx == currPaintIdx)) {
                cost = Math.min(cost, dp[idx]);
            }
            idx++;
        }
        return cost;
    }
}
