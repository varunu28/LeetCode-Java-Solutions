class Solution {
  public int[] missingRolls(int[] rolls, int mean, int n) {
    int currSum = Arrays.stream(rolls).sum();
    int missingSum = mean * (n + rolls.length) - currSum;
    if (missingSum > n * 6 || missingSum < n) {
      return new int[]{};
    }
    int[] ans = new int[n];
    int part = missingSum / n;
    int remainder = missingSum % n;
    Arrays.fill(ans, part);
    for (int i = 0; i < remainder; i++) {
      ans[i]++;
    }
    return ans;
  }
}
