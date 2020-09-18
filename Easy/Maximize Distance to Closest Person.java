class Solution {
  public int maxDistToClosest(int[] seats) {
    int start = -1;
    int max = 0;
    int n = seats.length;
    for (int i = 0; i < n; i++) {
      if (seats[i] == 0) {
        continue;
      }
      if (start == -1) {
        max = Math.max(max, i);
      }
      else {
        max = Math.max(max, (i - start) / 2);
      }
      start = i;
    }
    if (seats[n - 1] == 0) {
      max = Math.max(max, n - 1 - start);
    }
    return max;
  }
}
