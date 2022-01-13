class Solution {
  public int findMinArrowShots(int[][] points) {
    Arrays.sort(points, Comparator.comparingInt((int[] o) -> o[1]));
    int count = 0;
    int idx = 0;
    while (idx < points.length) {
      int currEnd = points[idx][1];
      while (idx < points.length && points[idx][0] <= currEnd) {
        idx++;
      }
      count++;
    }
    return count;
  }
}
