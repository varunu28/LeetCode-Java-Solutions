class Solution {
  public int coinChange(int[] coins, int amount) {
    Integer[] memo = new Integer[amount + 1];
    return coinChangeMemoization(coins, amount, memo);
  }

  private int coinChangeMemoization(int[] coins, int amount, Integer[] memo) {
    if (amount < 0) {
      return -1;
    }
    if (amount == 0) {
      return 0;
    }
    if (memo[amount] != null) {
      return memo[amount];
    }
    int minCount = Integer.MAX_VALUE;
    for (int coin : coins) {
      int count = coinChangeMemoization(coins, amount - coin, memo);
      if (count == -1) {
        continue;
      }
      minCount = Math.min(minCount, count + 1);
    }
    memo[amount] = minCount == Integer.MAX_VALUE ? -1 : minCount;
    return memo[amount];
  }
}
