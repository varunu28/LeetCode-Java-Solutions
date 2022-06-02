class Solution {
  private final int[][] DIRS = {{1, 2}, {2, 1}, {1, -2}, {-2, 1}, {2, -1}, {-2, -1}, {-1, -2}, {-1, 2}};
  
  public int minKnightMoves(int x, int y) {
    int numOfSteps = 0;
    boolean[][] visited = new boolean[607][607];
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{0, 0});
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int[] removed = queue.remove();
        if (removed[0] == x && removed[1] == y) {
          return numOfSteps;
        }
        for (int[] dir : DIRS) {
          int newX = removed[0] + dir[0];
          int newY = removed[1] + dir[1];
          if (visited[newX + 302][newY + 302]) {
            continue;
          }
          visited[newX + 302][newY + 302] = true;
          queue.add(new int[]{newX, newY});
        }
      }
      numOfSteps++;
    }
    return numOfSteps;
  }
}
