class Solution {
  public int findKthNumber(int m, int n, int k) {
    int low = 0;
    int high = m * n;
    while (low < high) {
      int mid = (low + high) / 2;
      int count = 0;
      for (int i = 1; i <= m; i++) {
        count += Math.min(n, mid / i);
      }
      if (count >= k) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }
}
