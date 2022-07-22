class Solution {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> result = new ArrayList<>();
    int idx = 0;
    int newStart = newInterval[0];
    int newEnd = newInterval[1];
    while (idx < intervals.length && newStart > intervals[idx][0]) {
      result.add(intervals[idx++]);
    }
    int[] currInterval = new int[2];
    if (result.isEmpty() || result.get(result.size() - 1)[1] < newStart) {
      result.add(newInterval);
    } else {
      currInterval = result.remove(result.size() - 1);
      currInterval[1] = Math.max(currInterval[1], newEnd);
      result.add(currInterval);
    }
    while (idx < intervals.length) {
      currInterval = intervals[idx++];
      int start = currInterval[0];
      int end = currInterval[1];
      if (result.get(result.size() - 1)[1] < start) {
        result.add(currInterval);
      } else {
        currInterval = result.remove(result.size() - 1);
        currInterval[1] = Math.max(currInterval[1], end);
        result.add(currInterval);
      }
    }
    return result.toArray(new int[result.size()][2]);
  }
}
