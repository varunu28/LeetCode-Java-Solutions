class Solution {
  public int eraseOverlapIntervals(int[][] intervals) {
    if (intervals.length == 0) {
      return 0;
    }
    Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
    int notRemoved = 1;
    int end = intervals[0][1];
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] >= end) {
        notRemoved++;
        end = intervals[i][1];
      }
    }
    return intervals.length - notRemoved;
  }
}
