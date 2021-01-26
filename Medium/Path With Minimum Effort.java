class Solution {
  public int minimumEffortPath(int[][] heights) {
    int rows = heights.length;
    int cols = heights[0].length;
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int[][] distance = new int[rows][cols];
    for (int i = 0; i < rows; i++) {
      Arrays.fill(distance[i], Integer.MAX_VALUE);
    }
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    pq.add(new int[]{0, 0, 0});
    while (!pq.isEmpty()) {
      int[] removed = pq.poll();
      int currDistance = removed[0];
      int x = removed[1];
      int y = removed[2];
      if (currDistance > distance[x][y]) {
        continue;
      }
      if (x == rows - 1 && y == cols - 1) {
        return currDistance;
      }
      for (int[] direction : directions) {
        int newX = x + direction[0];
        int newY = y + direction[1];
        if (newX < 0 || newX >= rows || newY < 0 || newY >= cols) {
          continue;
        }
        int newDistance = Math.max(currDistance, Math.abs(heights[newX][newY] - heights[x][y]));
        if (distance[newX][newY] > newDistance) {
          distance[newX][newY] = newDistance;
          pq.add(new int[]{newDistance, newX, newY});
        }
      }
    }
    return -1;
  }
}
