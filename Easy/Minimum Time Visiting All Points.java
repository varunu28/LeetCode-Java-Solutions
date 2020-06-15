class Solution {
  public int minTimeToVisitAllPoints(int[][] points) {
    int time = 0;
    for (int i = 1; i < points.length; i++) {
      int[] prevPoint = points[i - 1];
      int[] currPoint = points[i];
      time += Math.max(
        Math.abs(prevPoint[0] - currPoint[0]), Math.abs(prevPoint[1] - currPoint[1])
      );
    }
    return time;
  }
}
