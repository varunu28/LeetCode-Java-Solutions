class Solution {
    
    private static final int MOD = 1000_000_007;
    
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        dp[0] = 1;
        for (int i = 1; i <= high; i++) {
            if (i >= zero) {
                dp[i] += dp[i - zero];
            } 
            if (i >= one) {
                dp[i] += dp[i - one];
            }
            dp[i] %= MOD;
        }
        int result = 0;
        for (int i = low; i <= high; i++) {
            result = (result + dp[i]) % MOD;
        }
        return result;
    }
}
