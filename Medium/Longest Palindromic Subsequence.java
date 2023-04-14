class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        return helper(s, 0, n - 1, dp);
    }
    
    private int helper(String s, int startIdx, int endIdx, int[][] dp) {
        if (dp[startIdx][endIdx] != 0) {
            return dp[startIdx][endIdx];
        }
        if (startIdx > endIdx) {
            return 0;
        }
        if (startIdx == endIdx) {
            return 1;
        }
        if (s.charAt(startIdx) == s.charAt(endIdx)) {
            dp[startIdx][endIdx] = helper(s, startIdx + 1, endIdx - 1, dp) + 2;
        } else {
            dp[startIdx][endIdx] = Math.max(helper(s, startIdx + 1, endIdx, dp), helper(s, startIdx, endIdx - 1, dp));
        }
        return dp[startIdx][endIdx];
    }
}
