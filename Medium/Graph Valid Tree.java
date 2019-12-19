class Solution {
  public boolean validTree(int n, int[][] edges) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int[] edge : edges) {
      map.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
      map.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
    }
    Queue<Integer> queue = new LinkedList<>();
    int[] visited = new int[n];
    queue.add(0);
    visited[0] = 1;
    while (!queue.isEmpty()) {
      Integer removed = queue.remove();
      for (Integer connection : map.getOrDefault(removed, new HashSet<>())) {
        if (visited[connection] == 1) {
          return false;
        }
        if (visited[connection] == 0) {
          visited[connection] = 1;
          queue.add(connection);
        }
      }
      visited[removed] = 2;
    }
    for (int node : visited) {
      if (node == 0) {
        return false;
      }
    }
    return true;
  }
}
