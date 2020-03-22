class Solution {
  int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
  public int maximumMinimumPath(int[][] A) {
    int rows = A.length;
    int cols = A[0].length;
    boolean[][] visited = new boolean[rows][cols];
    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
      public int compare(int[] p1, int[] p2) {
        return p2[0] - p1[0];
      }
    });
    int maxVal = A[0][0];
    pq.add(new int[]{A[0][0], 0, 0});
    visited[0][0] = true;
    while (!pq.isEmpty()) {
      int[] removed = pq.poll();
      int x = removed[1];
      int y = removed[2];
      maxVal = Math.min(maxVal, removed[0]);
      if (x == rows - 1 && y == cols - 1) {
        break;
      }
      for (int[] dir : dirs) {
        int newX = x + dir[0];
        int newY = y + dir[1];
        if (newX >= 0 && newY >= 0 && newX < rows && newY < cols && !visited[newX][newY]) {
          pq.add(new int[]{A[newX][newY], newX, newY});
          visited[newX][newY] = true;
        }
      }
    }
    return maxVal;
  }
}
