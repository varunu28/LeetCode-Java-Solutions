class Solution {
  
  private static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

  public int maximumMinimumPath(int[][] grid) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[2] - o1[2]);
    pq.add(new int[]{0, 0, grid[0][0]});
    int numRows = grid.length;
    int numCols = grid[0].length;
    boolean[][] visited = new boolean[numRows][numCols];
    while (!pq.isEmpty()) {
      int[] removed = pq.poll();
      if (removed[0] == numRows - 1 && removed[1] == numCols - 1) {
        return removed[2];
      }
      visited[removed[0]][removed[1]] = true;
      for (int[] dir : DIRS) {
        int newX = removed[0] + dir[0];
        int newY = removed[1] + dir[1];
        if (newX >= 0 && newY >= 0 && newX < numRows && newY < numCols && !visited[newX][newY]) {
          pq.add(new int[]{newX, newY, Math.min(removed[2], grid[newX][newY])});
        }
      }
    }
    return -1;
  }
}
