class Solution {
  public String largestTimeFromDigits(int[] A) {
    int ans = -1;
    // Choose different indices i, j, k, l as a permutation of 0, 1, 2, 3
    for (int i = 0; i < 4; ++i) {
      for (int j = 0; j < 4; ++j) {
        if (j != i) {
          for (int k = 0; k < 4; ++k) {
            if (k != i && k != j) {
              int l = 6 - i - j - k;
              // For each permutation of A[i], read out the time and
              // record the largest legal time.
              int hours = 10 * A[i] + A[j];
              int mins = 10 * A[k] + A[l];
              if (hours < 24 && mins < 60) {
                ans = Math.max(ans, hours * 60 + mins);
              }
            }
          }
        }
      }
    }
    return ans >= 0 ? String.format("%02d:%02d", ans / 60, ans % 60) : "";
  }
}
