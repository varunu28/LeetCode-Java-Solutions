class Solution {
  public List<List<Integer>> getAncestors(int n, int[][] edges) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int[] edge : edges) {
      graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
    }
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      List<Integer> ancestors = new ArrayList<>();
      Set<Integer> visited = new HashSet<>();
      Queue<Integer> queue = new LinkedList<>(graph.getOrDefault(i, new ArrayList<>()));
      while (!queue.isEmpty()) {
        int removed = queue.remove();
        if (visited.contains(removed)) {
          continue;
        }
        ancestors.add(removed);
        visited.add(removed);
        queue.addAll(graph.getOrDefault(removed, new ArrayList<>()));
      }
      Collections.sort(ancestors);
      result.add(ancestors);
    }
    return result;
  }
}
