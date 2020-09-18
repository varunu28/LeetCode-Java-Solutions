class Solution {
  public int[] findRightInterval(int[][] intervals) {
    TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
    for (int i = 0; i < intervals.length; i++) {
      map.computeIfAbsent(intervals[i][0], k -> new PriorityQueue<>(
          Comparator.comparingInt(o -> intervals[o][0]))
      ).add(i);
    }
    int[] ans = new int[intervals.length];
    Arrays.fill(ans, -1);
    for (int i = 0; i < intervals.length; i++) {
      Integer upper = map.ceilingKey(intervals[i][1]);
      if (upper != null) {
        ans[i] = map.get(upper).peek();
      }
    }
    return ans;
  }
}
