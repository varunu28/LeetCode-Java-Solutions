class Solution {
    
    private static final int MOD = (int) 1000_000_007;

    public int numOfArrays(int n, int m, int k) {
        int[][][] dp = new int[n + 1][m + 1][k + 1];
        for (int i = 0; i < dp[0].length; i++) {
            dp[n][i][0] = 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m; j >= 0; j--) {
                for (int l = 0; l <= k; l++) {
                    int result = 0;
                    for (int num = 1; num <= j; num++) {
                        result = (result + dp[i + 1][j][l]) % MOD;
                    }
                    if (l > 0) {
                        for (int num = j + 1; num <= m; num++) {
                            result = (result + dp[i + 1][num][l - 1]) % MOD;
                        }
                    }
                    dp[i][j][l] = result;
                }
            }
        }
        return dp[0][0][k];
    }
}
