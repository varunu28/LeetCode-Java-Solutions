class Solution {

    private static final int MOD = 1000_000_007;

    public int numWays(int steps, int arrLen) {
        arrLen = Math.min(arrLen, steps);
        int[][] dp = new int[arrLen][steps + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = arrLen - 1; j >= 0; j--) {
                int result = dp[j][i - 1];
                if (j > 0) {
                    result = (result + dp[j - 1][i - 1]) % MOD;
                }
                if (j < arrLen - 1) {
                    result = (result + dp[j + 1][i - 1]) % MOD;
                }
                dp[j][i] = result;
            }
        }
        return dp[0][steps];
    }
}
