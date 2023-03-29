class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        Integer[][] dp = new Integer[n + 1][n + 1];
        return helper(satisfaction, 0, 1, dp);
    }
    
    private int helper(int[] satisfaction, int idx, int time, Integer[][] dp) {
        if (idx == satisfaction.length) {
            return 0;
        }
        if (dp[idx][time] != null) {
            return dp[idx][time];
        }
        dp[idx][time] = Math.max(satisfaction[idx] * time + helper(satisfaction, idx + 1, time + 1, dp),
                                 helper(satisfaction, idx + 1, time, dp));
        return dp[idx][time];
    }
}
