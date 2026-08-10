class Solution {
    public boolean winnerSquareGame(int n) {
        Boolean[] dp = new Boolean[100001];
        return recurse(n, dp);
    }

    private boolean recurse(int n, Boolean[] dp) {
        if (n <= 0) {
            return false;
        }
        if (dp[n] != null) {
            return dp[n];
        }
        for (int i = 1; i * i <= n; i++) {
            if (!recurse(n - i * i, dp)) {
                return dp[n] = true;
            }
        }
        return dp[n] = false;
    }
}
