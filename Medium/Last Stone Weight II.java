class Solution {
  public int lastStoneWeightII(int[] stones) {
    boolean[] dp = new boolean[1501];
    dp[0] = true;
    int sum = 0;
    for (int stone : stones) {
      sum += stone;
      for (int i = Math.min(1500, sum); i >= stone; i--) {
        dp[i] |= dp[i - stone]; 
      }
    }
    for (int i = sum / 2; i >= 0; i--) {
      if (dp[i]) {
        return sum - i - i;
      }
    }
    return 0;
  }
}
