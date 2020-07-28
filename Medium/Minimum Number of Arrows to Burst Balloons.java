class Solution {
  public int findMinArrowShots(int[][] points) {
    if (points.length == 0) {
      return 0;
    }
    Arrays.sort(points, new Comparator<int[]>(){
      public int compare(int[] p1, int[] p2) {
        int c = p1[0] - p2[0];
        if (c != 0) {
          return c;
        }
        return p1[1] - p2[1];
      }
    });
    int end = points[0][1];
    int count = 1;
    for (int i = 1; i < points.length; i++) {
      if (points[i][0] <= end) {
        end = Math.min(end, points[i][1]);
        continue;
      }
      count++;
      end = points[i][1];
    }
    return count;
  }
}
