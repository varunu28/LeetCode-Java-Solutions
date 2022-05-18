class Solution {
  public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Map<Integer, Integer> rank = new HashMap<>();
    Set<String> connectionSet = new HashSet<>();
    buildGraph(n, connections, graph, rank, connectionSet);
    dfs(0, 0, graph, rank, connectionSet);
    List<List<Integer>> result = new ArrayList<>();
    for (String conn : connectionSet) {
      int nodeOne = Integer.parseInt(conn.split("-")[0]);
      int nodeTwo = Integer.parseInt(conn.split("-")[1]);
      result.add(Arrays.asList(nodeOne, nodeTwo));
    }
    return result;
  }
  
  private void buildGraph(int n, List<List<Integer>> connections, Map<Integer, List<Integer>> graph, Map<Integer, Integer> rank, Set<String> connectionSet) {
    for (int i = 0; i < n; i++) {
      graph.put(i, new ArrayList<>());
      rank.put(i, null);
    }
    for (List<Integer> edge : connections) {
      graph.get(edge.get(0)).add(edge.get(1));
      graph.get(edge.get(1)).add(edge.get(0));
      connectionSet.add(
        Math.min(edge.get(0), edge.get(1)) + "-" + Math.max(edge.get(0), edge.get(1)));
    }
  }
  
  private int dfs(int node, int discoveryRank, Map<Integer, List<Integer>> graph, Map<Integer, Integer> rank, Set<String> connectionSet) {
    if (rank.get(node) != null) {
      return rank.get(node);
    }
    rank.put(node, discoveryRank);
    int minimumRank = discoveryRank + 1;
    for (Integer neighbor : graph.get(node)) {
      Integer neighborRank = rank.get(neighbor);
      if (neighborRank != null && neighborRank == discoveryRank - 1) {
        continue;
      }
      int recursiveRank = dfs(neighbor, discoveryRank + 1, graph, rank, connectionSet);
      if (recursiveRank <= discoveryRank) {
        connectionSet.remove(Math.min(node, neighbor) + "-" + Math.max(node, neighbor));
      }
      minimumRank = Math.min(minimumRank, recursiveRank);
    }
    return minimumRank;
  }
}
