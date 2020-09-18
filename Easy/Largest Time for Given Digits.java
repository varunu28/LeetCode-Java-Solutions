class Solution {
  public String largestTimeFromDigits(int[] A) {
    int ans = -1;
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        if (i != j) {
          for (int k = 0; k < 4; k++) {
            if (i != k && j != k) {
              for (int l = 0; l < 4; l++) {
                if (l != i && l != j && l != k) {
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
      }
    }
    return ans >= 0 ? String.format("%02d:%02d", ans / 60, ans % 60) : "";
  }
}
