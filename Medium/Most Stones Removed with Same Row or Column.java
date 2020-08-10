class Solution {
  public int removeStones(int[][] stones) {
    Set<int[]> visited = new HashSet<>();
    int numOfIslands = 0;
    for (int[] stone : stones) {
      if (!visited.contains(stone)) {
        dfs(stones, visited, stone);
        numOfIslands++;
      }
    }
    return stones.length - numOfIslands;
  }
  
  private void dfs(int[][] stones, Set<int[]> visited, int[] stone) {
    visited.add(stone);
    for (int[] st : stones) {
      if ((st[0] == stone[0] || st[1] == stone[1]) && !visited.contains(st)) {
        dfs(stones, visited, st);
      }
    }
  }
}
