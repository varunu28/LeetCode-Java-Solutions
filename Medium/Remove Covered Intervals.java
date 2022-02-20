class Solution {
  public int removeCoveredIntervals(int[][] intervals) {
    Arrays.sort(intervals, (o1, o2) -> {
      int c = o1[0] - o2[0];
      if (c != 0) {
        return c;
      }
      return o2[1] - o1[1];
    });
    int currIdx = 0;
    int n = intervals.length;
    int intervalCount = 0;
    while (currIdx < n) {
      int[] currInterval = intervals[currIdx];
      int currIntervalStart = currInterval[0];
      int currIntervalEnd = currInterval[1];
      currIdx++;
      while (currIdx < n &&
          intervals[currIdx][0] >= currIntervalStart &&
          intervals[currIdx][1] <= currIntervalEnd) {
        currIdx++;
      }
      intervalCount++;
    }
    return intervalCount;
  }   
}
