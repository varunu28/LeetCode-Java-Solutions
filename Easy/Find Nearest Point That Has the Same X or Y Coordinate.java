class Solution {
  public int nearestValidPoint(int x, int y, int[][] points) {
    int[] basePoint = new int[]{x, y};
    return IntStream.range(0, points.length).mapToObj(i -> new Point(basePoint, i, points[i]))
        .filter(
            Point::isMatch)
        .sorted(Comparator.comparingInt(Point::getManhattanDistance).thenComparing(Point::getIdx))
        .map(Point::getIdx).findFirst().orElse(-1);
  }

  private static class Point {
    int[] basePoint;
    int idx;
    int[] currPoint;

    public Point(int[] basePoint, int idx, int[] currPoint) {
      this.basePoint = basePoint;
      this.idx = idx;
      this.currPoint = currPoint;
    }

    public int getIdx() {
      return idx;
    }

    public int getManhattanDistance() {
      return Math.abs(currPoint[0] - basePoint[0]) + Math.abs(currPoint[1] - basePoint[1]);
    }

    public boolean isMatch() {
      return currPoint[0] == basePoint[0] || currPoint[1] == basePoint[1];
    }
  }
}
