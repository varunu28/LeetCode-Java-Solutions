class Solution {
    int MOD = 1000000007;
    public int numRollsToTarget(int d, int f, int target) {
        Integer[][] dp = new Integer[d + 1][target + 1];
        return helper(d, f, target, dp);
    }
    
    private int helper(int d, int f, int target, Integer[][] dp) {
        if (d == 0 || target <= 0) {
            return d == target ? 1 : 0;
        }
        if (dp[d][target] != null) {
            return dp[d][target];
        }
        
        dp[d][target] = 0;
        for (int i = 1; i <= f; i++) {
            dp[d][target] = (dp[d][target] + helper(d - 1, f, target - i, dp)) % MOD; 
        }
        
        return dp[d][target];
    }
}
