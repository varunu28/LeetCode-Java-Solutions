class Solution {
  public boolean canCross(int[] stones) {
    int[][] memo = new int[stones.length][stones.length];
    for (int[] row : memo) {
      Arrays.fill(row, -1);
    }
    return helper(stones, 0, 0, memo) == 1;
  }
  
  private int helper(int[] stones, int idx, int jumpSize, int[][] memo) {
    if (memo[idx][jumpSize] >= 0) {
      return memo[idx][jumpSize];
    }
    for (int i = idx + 1; i < stones.length; i++) {
      int gap = stones[i] - stones[idx];
      if (gap >= jumpSize - 1 && gap <= jumpSize + 1) {
        if (helper(stones, i, gap, memo) == 1) {
          memo[idx][gap] = 1;
          return 1;
        }
      }
    }
    memo[idx][jumpSize] = (idx == stones.length - 1) ? 1 : 0;
    return memo[idx][jumpSize];
  }
}
