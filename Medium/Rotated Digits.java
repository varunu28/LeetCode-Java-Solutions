class Solution {
  public int rotatedDigits(int n) {
    int[] dp = new int[n + 1];
    int result = 0;
    for (int i = 0; i <= Math.min(n, 9); i++) {
      if (i == 0 || i == 1 || i == 8) {
        dp[i] = 1;
      } else if (i == 2 || i == 5 || i == 6 || i == 9) {
        dp[i] = 2;
        result++;
      }
    }
    for (int i = 10; i <= n; i++) {
      int factor = dp[i / 10];
      int remainder = dp[i % 10];
      if (factor == 1 && remainder == 1) {
        dp[i] = 1;
      } else if (factor >= 1 && remainder >= 1) {
        dp[i] = 2;
        result++;
      }
    }
    return result;
  }
}
