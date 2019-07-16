class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        Integer[][] dp = new Integer[A.length][B.length];
        return helper(A, 0, B, 0, dp);
    }
    
    private int helper(int[] A, int i, int[] B, int j, Integer[][] dp) {
        if (i >= A.length || j >= B.length) {
            return 0;
        }
        
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        
        if (A[i] == B[j]) {
            dp[i][j] = 1 + helper(A, i + 1, B, j + 1, dp);
        }
        else {
            dp[i][j] = Math.max(helper(A, i + 1, B, j, dp), helper(A, i, B, j + 1, dp));
        }
        
        return dp[i][j];
    }
}
