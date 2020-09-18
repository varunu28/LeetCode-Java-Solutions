class Solution {
  public int findJudge(int N, int[][] trust) {
    int[] trustScore = new int[N + 1];
    for (int[] trst : trust) {
      trustScore[trst[0]]--;
      trustScore[trst[1]]++;
    }
    for (int i = 1; i <= N; i++) {
      if (trustScore[i] == (N - 1)) {
        return i;
      }
    }
    return -1;
  }
}
