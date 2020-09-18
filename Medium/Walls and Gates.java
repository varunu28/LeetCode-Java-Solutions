class Solution {
  int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
  public void wallsAndGates(int[][] rooms) {
    if (rooms.length == 0 || rooms[0].length == 0) {
      return;
    }
    final int INF = Integer.MAX_VALUE;
    Queue<int[]> queue = new LinkedList<>();
    int rows = rooms.length;
    int cols = rooms[0].length;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (rooms[i][j] == 0) {
          queue.add(new int[]{i, j});
        }
      }
    }
    while (!queue.isEmpty()) {
      int[] removed = queue.remove();
      int x = removed[0];
      int y = removed[1];
      for (int[] dir : dirs) {
        int newX = x + dir[0];
        int newY = y + dir[1];
        if (newX >= 0 && newY >= 0 && newX < rows && newY < cols && rooms[newX][newY] == INF) {
          rooms[newX][newY] = rooms[x][y] + 1;
          queue.add(new int[]{newX, newY});
        }
      }
    }
  }
}
