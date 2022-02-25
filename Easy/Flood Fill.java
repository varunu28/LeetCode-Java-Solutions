class Solution {
  private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
  
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int numOfRows = image.length;
    int numOfCols = image[0].length;
    int originalColor = image[sr][sc];
    if (newColor == originalColor) {
      return image;
    }
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{sr, sc});
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int[] coordinate = queue.remove();
        int xPoint = coordinate[0];
        int yPoint = coordinate[1];
        image[xPoint][yPoint] = newColor;
        for (int[] dir : DIRS) {
          int newXPoint = xPoint + dir[0];
          int newYPoint = yPoint + dir[1];
          if (newXPoint >= 0 && newYPoint >= 0 && newXPoint < numOfRows && newYPoint < numOfCols && image[newXPoint][newYPoint] == originalColor) {
            queue.add(new int[]{newXPoint, newYPoint});
          }
        }
      }
    }
    return image;
  }
}
