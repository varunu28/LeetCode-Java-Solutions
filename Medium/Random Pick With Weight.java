class Solution {
  private int[] prefixSum;
  private int totalPrefixSum;
  
  public Solution(int[] w) {
    this.prefixSum = new int[w.length];
    int currPrefixSum = 0;
    for (int i = 0; i < w.length; i++) {
      currPrefixSum += w[i];
      this.prefixSum[i] = currPrefixSum;
    }
    this.totalPrefixSum = currPrefixSum;
  }

  public int pickIndex() {
    double randomTarget = this.totalPrefixSum * Math.random();
    int left = 0;
    int right = this.prefixSum.length;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (randomTarget > this.prefixSum[mid]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
