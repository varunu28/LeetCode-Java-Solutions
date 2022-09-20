class Solution {
  public int maxDistToClosest(int[] seats) {
    int n = seats.length;
    int maxDistance = 0;
    int start = -1;
    for (int i = 0; i < n; i++) {
      if (seats[i] == 1) {
        maxDistance = start == -1 ? i : Math.max(maxDistance, (i - start) / 2);
        start = i;
      }
    }
    return Math.max(maxDistance, n - 1 - start);
  }
}
