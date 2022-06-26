class Solution {
  public int maxScore(int[] cardPoints, int k) {
    int n = cardPoints.length;
    int[] prefixSum = new int[k + 1];
    int[] suffixSum = new int[k + 1];
    for (int i = 0; i < k; i++) {
      prefixSum[i + 1] = cardPoints[i] + prefixSum[i];
      suffixSum[i + 1] = cardPoints[n - i - 1] + suffixSum[i];
    }
    int result = 0;
    for (int i = 0; i <= k; i++) {
      int currScore = prefixSum[i] + suffixSum[k - i];
      result = Math.max(result, currScore);
    }
    return result;
  }
}
