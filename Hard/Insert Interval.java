class Solution {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> list = new ArrayList<>();
    boolean merged = false;
    int idx = 0;
    int n = intervals.length;
    while (idx < n) {
      if (merged) {
        list.add(intervals[idx++]);
        continue;
      }
      if (isOverlap(intervals[idx], newInterval)) {
        int start = Math.min(intervals[idx][0], newInterval[0]);
        int currEnd = Math.max(intervals[idx][1], newInterval[1]);
        idx++;
        while (idx < n && intervals[idx][0] <= currEnd) {
          currEnd = Math.max(currEnd, intervals[idx][1]);
          idx++;
        }
        list.add(new int[]{start, currEnd});
        merged = true;
      }
      else if (intervals[idx][0] > newInterval[1]) {
        list.add(newInterval);
        list.add(intervals[idx++]);
        merged = true;
      }
      else {
        list.add(intervals[idx++]);
      }
    }
    if (!merged) {
      list.add(newInterval);
    }
    int[][] ans = new int[list.size()][2];
    for (int i = 0; i < list.size(); i++) {
      ans[i] = list.get(i);
    }
    return ans;
  }
  
  private boolean isOverlap(int[] i1, int[] i2) {
    return (
      (i2[0] <= i1[1] && i2[0] >= i1[0]) ||
      (i2[1] >= i1[0] && i2[0] <= i1[0]) ||
      (i2[0] >= i1[0] && i2[1] <= i1[1])
    );
  }
}
