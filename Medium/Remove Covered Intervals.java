class Solution {
  public int removeCoveredIntervals(int[][] intervals) {
    Arrays.sort(intervals, new Comparator<int[]>(){
      public int compare(int[] i1, int[] i2) {
        int c = i2[1] - i1[1];
        if (c != 0) {
          return c;
        }
        return i1[0] - i2[0];
      }
    });
    int idx = 0;
    int count = 0;
    while (idx < intervals.length) {
      int[] currInterval = intervals[idx];
      idx++;
      while (idx < intervals.length && intervals[idx][0] >= currInterval[0] && intervals[idx][1] <= currInterval[1]
      ) {
        count++;
        idx++;
      }
    }
    return intervals.length - count;
  }
}
