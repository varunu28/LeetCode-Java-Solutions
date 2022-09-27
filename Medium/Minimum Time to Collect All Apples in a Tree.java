class Solution {
  public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
    Map<Integer, Set<Integer>> tree = new HashMap<>();
    for (int[] edge : edges) {
      tree.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
      tree.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
    }
    Set<Integer> visited = new HashSet<>();
    return dfs(0, hasApple, visited, tree);
  }
  
  private int dfs(int node, List<Boolean> hasApple, Set<Integer> visited, Map<Integer, Set<Integer>> tree) {
    visited.add(node);
    int result = 0;
    for (Integer child : tree.getOrDefault(node, new HashSet<>())) {
      if (!visited.contains(child)) {
        result += dfs(child, hasApple, visited, tree);
      }
    }
    if ((result > 0 || hasApple.get(node)) && node != 0) {
      result += 2;
    }
    return result;
  }
}
