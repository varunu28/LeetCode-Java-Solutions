class Solution {
  public boolean validPath(int n, int[][] edges, int start, int end) {
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    for (int[] edge : edges) {
      graph.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
      graph.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
    }
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    Set<Integer> visited = new HashSet<>();
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int removed = queue.remove();
        if (removed == end) {
          return true;
        }
        visited.add(removed);
        for (Integer connection : graph.getOrDefault(removed, new HashSet<>())) {
          if (!visited.contains(connection)) {
            queue.add(connection);
          }
        }
      }
    }
    return false;
  }
}
