class Solution {
  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, new Comparator<int[]>(){
      public int compare(int[] o1, int[] o2) {
        int c = o1[0] - o2[0];
        if (c != 0) {
          return c;
        }
        return o1[1] - o2[1];
      }
    });
    List<int[]> intervalList = new ArrayList<>();
    int end = 0;
    int n = intervals.length;
    int currStart = -1;
    int currEnd = -1;
    while (end < n) {
      if (currStart == -1 && currEnd == -1) {
        currStart = intervals[end][0];
        currEnd = intervals[end][1];
        end++;
      }
      if (end < n) {
        if (currEnd >= intervals[end][0]) {
          currEnd = Math.max(intervals[end][1], currEnd);
          end++;
        }
        else {
          intervalList.add(new int[]{currStart, currEnd});
          currStart = -1;
          currEnd = -1;
        }
      }
      if (end == n && currStart != -1 && currEnd != -1) {
        intervalList.add(new int[]{currStart, currEnd});
      }
    }
    int[][] ans = new int[intervalList.size()][2];
    for (int i = 0; i < intervalList.size(); i++) {
      ans[i] = intervalList.get(i);
    }
    return ans;
  }
}
