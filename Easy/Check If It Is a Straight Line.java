class Solution {
  public boolean checkStraightLine(int[][] coordinates) {
    if (coordinates.length <= 2) {
      return true;
    }
    int[] p1 = coordinates[0];
    int[] p2 = coordinates[1];
    for (int i = 2; i < coordinates.length; i++) {
      if (!isCollinear(coordinates[i], p1, p2)) {
        return false;
      }
    }
    return true;
  }
  
  private boolean isCollinear(int[] c, int[] p1, int[] p2) {
    if (p1[0] == c[0] || p2[0] == c[0]) {
      return false;
    }
    int slope1 = (p1[1] - c[1]) / (p1[0] - c[0]);
    int slope2 = (p2[1] - c[1]) / (p2[0] - c[0]);
    return slope1 == slope2;
  }
}
