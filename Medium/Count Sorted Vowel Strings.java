class Solution {
  public int countVowelStrings(int n) {
    Integer[][] memo = new Integer[n + 1][5];
    return topDownDP(n, 0, memo);
  }
  
  private int topDownDP(int n, int idx, Integer[][] memo) {
    if (n == 0) {
      return 1;
    } else if (idx == 5) {
      return 0;
    } else if (memo[n][idx] != null) {
      return memo[n][idx];
    }
    int numOfPermutations = topDownDP(n, idx + 1, memo);
    numOfPermutations += topDownDP(n - 1, idx, memo);
    return memo[n][idx] = numOfPermutations;
  }
}
