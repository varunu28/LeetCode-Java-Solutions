class Solution {
  public int findJudge(int n, int[][] trust) {
    int[] trustScore = new int[n + 1];
    for (int[] trustPair : trust) {
      trustScore[trustPair[1]]++;
      trustScore[trustPair[0]]--;
    }
    for (int i = 1; i <= n; i++) {
      if (trustScore[i] == n - 1) {
        return i;
      }
    }
    return -1;
  }
}
