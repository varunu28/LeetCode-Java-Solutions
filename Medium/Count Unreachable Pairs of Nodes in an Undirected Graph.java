class Solution {
  public long countPairs(int n, int[][] edges) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int[] edge : edges) {
      graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
      graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
    }
    long unreachableNodes = (((long) n) * (n - 1)) / 2;
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        long[] reachCount = {0};
        dfs(graph, i, reachCount, visited);
        unreachableNodes -= (reachCount[0] * (reachCount[0] - 1)) / 2;
      }      
    }
    return unreachableNodes;
  }
  
  private void dfs(Map<Integer, List<Integer>> graph, int node, long[] reachCount, boolean[] visited) {
    visited[node] = true;
    reachCount[0]++;
    for (Integer conn : graph.getOrDefault(node, new ArrayList<>())) {
      if (!visited[conn]) {
        dfs(graph, conn, reachCount, visited);
      }
    }
  }
}
