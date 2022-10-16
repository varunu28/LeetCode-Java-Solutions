class Solution {
  public int minDifficulty(int[] jobDifficulty, int d) {
    int n = jobDifficulty.length;
    if (n < d) {
      return -1;
    }
    Integer[][] dp = new Integer[n][d + 1];
    return minDifficulty(/* index= */0, d, jobDifficulty, dp);
  }
  
  private int minDifficulty(int index, int dLeft, int[] jobDifficulty, Integer[][] dp)  {
    if (dp[index][dLeft] != null) {
      return dp[index][dLeft];
    }
    if (dLeft == 1) {
      int result = 0;
      for (int j = index; j < jobDifficulty.length; j++) {
        result = Math.max(result, jobDifficulty[j]);
      }
      return result;
    }
    int result = Integer.MAX_VALUE;
    int dailyMaxJobDiff = 0;
    for (int j = index; j < jobDifficulty.length - dLeft + 1; j++) {
      dailyMaxJobDiff = Math.max(dailyMaxJobDiff, jobDifficulty[j]);
      result = Math.min(result, dailyMaxJobDiff + minDifficulty(j + 1, dLeft - 1, jobDifficulty, dp));
    }
    return dp[index][dLeft] = result;
  } 
}
