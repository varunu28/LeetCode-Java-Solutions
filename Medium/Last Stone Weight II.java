class Solution {
  public int lastStoneWeightII(int[] stones) {
    int sum = 0;
    for (int stone : stones) {
      sum += stone;
    }
    int[] dp = new int[sum / 2 + 1];
    for (int i = 1; i <= stones.length; i++) {
      for (int j = sum / 2; j >= stones[i - 1]; j--) {
        dp[j] = Math.max(dp[j], dp[j - stones[i - 1]] + stones[i - 1]);
      }
    }
    return sum - 2 * dp[sum / 2];
  }
}
