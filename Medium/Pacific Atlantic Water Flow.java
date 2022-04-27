class Solution {
  private final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
  
  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    int numRows = heights.length;
    int numCols = heights[0].length;
    Queue<int[]> pacificQueue = new LinkedList<>();
    Queue<int[]> atlanticQueue = new LinkedList<>();
    for (int i = 0; i < numRows; i++) {
      pacificQueue.add(new int[]{i, 0});
      atlanticQueue.add(new int[]{i, numCols - 1});
    }
    for (int i = 0; i < numCols; i++) {
      pacificQueue.add(new int[]{0, i});
      atlanticQueue.add(new int[]{numRows - 1, i});
    }
    boolean[][] pacificReachable = bfs(pacificQueue, heights);
    boolean[][] atlanticReachable = bfs(atlanticQueue, heights);
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numCols; j++) {
        if (pacificReachable[i][j] && atlanticReachable[i][j]) {
          result.add(Arrays.asList(i, j));
        }
      }
    }
    return result;
  }
  
  private boolean[][] bfs(Queue<int[]> queue, int[][] heights) {
    int numRows = heights.length;
    int numCols = heights[0].length;
    boolean[][] reachable = new boolean[numRows][numCols];
    while (!queue.isEmpty()) {
      int[] removed = queue.remove();
      int x = removed[0];
      int y = removed[1];
      reachable[x][y] = true;
      for (int[] dir : DIRS) {
        int newX = x + dir[0];
        int newY = y + dir[1];
        if (newX < 0 || newY < 0 || newX >= numRows || newY >= numCols || reachable[newX][newY]) {
          continue;
        }
        if (heights[newX][newY] >= heights[x][y]) {
          queue.add(new int[]{newX, newY});
        }
      }
    }
    return reachable;
  }
}
