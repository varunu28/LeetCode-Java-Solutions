class Solution {
  public boolean makesquare(int[] matchsticks) {
    int n = matchsticks.length;
    int sum = 0;
    for (int stick : matchsticks) {
      sum += stick;
    }
    int possibleSide = sum / 4;
    if (possibleSide * 4 != sum) {
      return false;
    }
    Arrays.sort(matchsticks);
    return dfs(new int[4], matchsticks, possibleSide, matchsticks.length - 1);
  }
  
  private boolean dfs(int[] sum, int[] sticks, int possibleSide, int idx) {
    if (idx == -1) {
      return sum[0] == sum[1] && sum[1] == sum[2] && sum[2] == sum[3];
    }
    int stick = sticks[idx];
    for (int i = 0; i < 4; i++) {
      if (sum[i] + stick <= possibleSide) {
        sum[i] += stick;
        if (dfs(sum, sticks, possibleSide, idx - 1)) {
          return true;
        }
        sum[i] -= stick;
      }
    }
    return false;
  }
}
