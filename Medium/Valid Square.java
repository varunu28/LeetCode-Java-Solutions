class Solution {
  public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    int[][] points = {p1, p2, p3, p4};
    Arrays.sort(points, (i1, i2) -> i2[0] == i1[0] ? i1[1] - i2[1] : i1[0] - i2[0]);
    return (
      getDistance(points[0], points[1]) != 0 && 
      getDistance(points[0], points[1]) == getDistance(points[1], points[3]) && 
      getDistance(points[1], points[3]) == getDistance(points[3], points[2]) && 
      getDistance(points[3], points[2]) == getDistance(points[2], points[0]) && 
      getDistance(points[0],points[3])==getDistance(points[1],points[2])
    );
  }

  private double getDistance(int[] p1, int[] p2) {
    return (p2[1] - p1[1]) * (p2[1] - p1[1]) + (p2[0] - p1[0]) * (p2[0] - p1[0]);
  }
}
