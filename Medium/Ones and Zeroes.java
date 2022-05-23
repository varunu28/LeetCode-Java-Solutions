class Solution {
  public int findMaxForm(String[] strs, int m, int n) {
    int[][] dp = new int[m + 1][n + 1];
    for (String s : strs) {
      int[] count = getCountForZeroAndOne(s);
      for (int zeroes = m; zeroes >= count[0]; zeroes--) {
        for (int ones = n; ones >= count[1]; ones--) {
          dp[zeroes][ones] = Math.max(1 + dp[zeroes - count[0]][ones - count[1]], dp[zeroes][ones]);
        }
      }
    }
    return dp[m][n];
  }
  
  private int[] getCountForZeroAndOne(String s) {
    int[] count = {0, 0};
    for (char c : s.toCharArray()) {
      if (c == '0') {
        count[0]++;
      } else {
        count[1]++;
      }
    }
    return count;
  }
}
