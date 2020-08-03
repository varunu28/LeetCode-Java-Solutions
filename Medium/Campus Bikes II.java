class Solution {
  int minDist;
  public int assignBikes(int[][] workers, int[][] bikes) {
    minDist = Integer.MAX_VALUE;
    dfs(new boolean[bikes.length], workers, 0, bikes, 0);
    return minDist;
  }
  
  private void dfs(boolean[] visited, int[][] workers, int currIdx, int[][] bikes, int distance) {
    if (currIdx >= workers.length) {
      minDist = Math.min(minDist, distance);
      return;
    }
    if (distance > minDist) {
      return;
    }
    for (int i = 0; i < bikes.length; i++) {
      if (visited[i]) {
        continue;
      }
      visited[i] = true;
      dfs(visited, workers, currIdx + 1, bikes, distance + getManahattanDist(bikes[i], workers[currIdx]));
      visited[i] = false;
    }
  }
  
  private int getManahattanDist(int[] p1, int[] p2) {
    return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
  }
}
