class Solution {
  public int minDistance(String word1, String word2) {
    int[][] dp = new int[word1.length() + 1][word2.length() + 1];
    return word1.length() + word2.length() - 2 * longestCommonSubsequence(word1, word2, word1.length(), word2.length(), dp);
  }
  
  private int longestCommonSubsequence(String word1, String word2, int m, int n, int[][] dp) {
    if (m == 0 || n == 0) {
      return 0;
    }
    if (dp[m][n] > 0) {
      return dp[m][n];
    }
    if (word1.charAt(m - 1) == word2.charAt(n - 1)) {
      dp[m][n] = 1 + longestCommonSubsequence(word1, word2, m - 1, n - 1, dp);
    } else {
      dp[m][n] = Math.max(longestCommonSubsequence(word1, word2, m - 1, n, dp), longestCommonSubsequence(word1, word2, m, n - 1, dp));
    }
    return dp[m][n];
  }
}
