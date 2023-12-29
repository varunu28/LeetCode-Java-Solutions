class Solution {
    
    private static final int INVALID_VALUE = 300_001;

    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) {
            return -1;
        }
        Integer[][][] dp = new Integer[jobDifficulty.length][d + 1][1001];
        return dfs(jobDifficulty, 0, d, 0, dp);
    }

    private int dfs(int[] jobDifficulty, int idx, int d, int currMax, Integer[][][] dp) {
        if (idx == jobDifficulty.length) {
            return d == 0 ? 0 : INVALID_VALUE;
        }
        if (d == 0) {
            return INVALID_VALUE;
        }
        if (dp[idx][d][currMax] != null) {
            return dp[idx][d][currMax];
        }
        currMax = Math.max(currMax, jobDifficulty[idx]);
        int result = Math.min(dfs(
                jobDifficulty, idx + 1, d, currMax, dp), // continue same sequence
                currMax + dfs(jobDifficulty, idx + 1, d - 1, 0, dp) // break sequence
        );
        return dp[idx][d][currMax] = result;
    }
}
