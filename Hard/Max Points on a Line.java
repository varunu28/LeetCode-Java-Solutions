class Solution {
  public int maxPoints(int[][] points) {
    int max = 0;
    for (int i = 0; i < points.length - 1; i++) {
      Map<Double, Integer> map = new HashMap<>();
      for (int j = i + 1; j < points.length; j++) {
        double slope = calculateSlope(points[i], points[j]);
        map.put(slope, map.getOrDefault(slope, 0) + 1);
        max = Math.max(max, map.get(slope));
      }
    }
    return max + 1;
  }
  
  private double calculateSlope(int[] p1, int[] p2) {
    double y = (p2[1] - p1[1]) * 1.0;
    double x = (p2[0] - p1[0]) * 1.0;
    if (x == 0) {
      return Double.NaN;
    }
    if(y == 0) {
      return 0.0;
    }
    return ((double) y * 1.0) / x;
  }
}
