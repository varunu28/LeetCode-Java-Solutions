class Solution {
    public int integerBreak(int n) {
        if (n < 4) {
            return n - 1;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= 3; i++) {
            dp[i] = i;
        }
        for (int i = 4; i <= n; i++) {
            int result = i;
            for (int j = 2; j < i; j++) {
                result = Math.max(result, j * dp[i - j]);
            }
            dp[i] = result;
        }
        return dp[n];
    }
}
