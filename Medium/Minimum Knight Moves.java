class Solution {
  public final int[][] DIRS = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
  public int minKnightMoves(int x, int y) {
    int currX = 0;
    int currY = 0;
    int targetX = Math.abs(x);
    int targetY = Math.abs(y);
    Set<String> visited = new HashSet<>();
    Queue<int[]> queue = new LinkedList<>();
    int numOfSteps = 0;
    visited.add(currX + "|" + currY);
    queue.add(new int[]{currX, currY});
    while (!queue.isEmpty()) {
      int size = queue.size();
      boolean found = false;
      while (size-- > 0) {
        int[] removed = queue.remove();
        if (removed[0] == targetX && removed[1] == targetY) {
          found = true;
          break;
        }
        for (int[] dir : DIRS) {
          int newX = removed[0] + dir[0];
          int newY = removed[1] + dir[1];
          if (!visited.contains(newX + "|" + newY) && newX >= -1 && newY >= -1) {
            visited.add(newX + "|" + newY);
            queue.add(new int[]{newX, newY});
          }
        }
      }
      if (found) {
        break;
      }
      numOfSteps++;
    }
    return numOfSteps;
  }
}
