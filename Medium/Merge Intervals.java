class Solution {
  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt(o -> o[1]));
    List<int[]> mergedIntervals = new ArrayList<>();
    int idx = 0;
    while (idx < intervals.length) {
      int currentStart = intervals[idx][0];
      int currentEnd = intervals[idx][1];
      idx++;
      while (idx < intervals.length && intervals[idx][0] <= currentEnd) {
        currentEnd = Math.max(intervals[idx][1], currentEnd);
        idx++;
      }
      mergedIntervals.add(new int[]{currentStart, currentEnd});
    }
    int[][] result = new int[mergedIntervals.size()][2];
    for (int i = 0; i < mergedIntervals.size(); i++) {
      result[i] = mergedIntervals.get(i);
    }
    return result;
  }
}
