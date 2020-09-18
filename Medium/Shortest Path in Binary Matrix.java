class Solution {
  int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};
  public int shortestPathBinaryMatrix(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1) {
      return -1;
    }
    boolean[][] visited = new boolean[rows][cols];
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{0, 0});
    visited[0][0] = true;
    int steps = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int[] removed = queue.remove();
        if (removed[0] == (rows - 1) && removed[1] == (cols - 1)) {
          return steps + 1;
        }
        for (int i = 0; i < dirs.length; i++) {
          int newX = removed[0] + dirs[i][0];
          int newY = removed[1] + dirs[i][1];
          if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && !visited[newX][newY] && grid[newX][newY] == 0) {
            queue.add(new int[]{newX, newY});
            visited[newX][newY] = true;
          }
        }
      }
      steps++;
    }
    return -1;
  }
}
