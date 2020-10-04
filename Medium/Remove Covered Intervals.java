class Solution {
  public int removeCoveredIntervals(int[][] intervals) {
    Arrays.sort(intervals, (o1, o2) -> {
      int c = o1[0] - o2[0];
      if (c != 0) {
        return c;
      }
      return o2[1] - o1[1];
    });
    int count = 0;
    int idx = 0;
    int n = intervals.length;
    while (idx < n) {
      int start = intervals[idx][0];
      int end = intervals[idx][1];
      idx++;
      while (idx < n && intervals[idx][1] <= end) {
        idx++;
      }
      count++;
    }
    return count;
  }
}
