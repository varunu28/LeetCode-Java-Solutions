class Solution {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        Boolean[][][] dp = new Boolean[n][n][n + 1];
        return helper(s1, s2, 0, 0, n, dp);
    }
    
    private boolean helper(String s1, String s2, int idxOne, int idxTwo, int n, Boolean[][][] dp) {
        if (dp[idxOne][idxTwo][n] != null) {
            return dp[idxOne][idxTwo][n];
        }
        if (n == 1) {
            return dp[idxOne][idxTwo][n]  = s1.charAt(idxOne) == s2.charAt(idxTwo);
        }
        for (int l = 1; l < n; l++) {
            if (helper(s1, s2, idxOne, idxTwo, l, dp) && helper(s1, s2, idxOne + l, idxTwo + l, n - l, dp)) {
                return dp[idxOne][idxTwo][n] = true;
            }
            if (helper(s1, s2, idxOne, idxTwo + n - l, l, dp) && helper(s1, s2, idxOne + l, idxTwo, n - l, dp)) {
                return dp[idxOne][idxTwo][n] = true;
            }
        }
        return dp[idxOne][idxTwo][n] = false;
    }
}
