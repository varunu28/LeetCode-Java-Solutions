class Solution {
  public int reachableNodes(int n, int[][] edges, int[] restricted) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int[] edge : edges) {
      graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
      graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
    }
    Set<Integer> restrictedSet = Arrays.stream(restricted).boxed().collect(Collectors.toSet());
    Set<Integer> visited = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);
    visited.add(0);
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int node = queue.remove();
        for (Integer neighbor : graph.getOrDefault(node, new ArrayList<>())) {
          if (restrictedSet.contains(neighbor) || visited.contains(neighbor)) {
            continue;
          }
          queue.add(neighbor);
          visited.add(neighbor);
        }
      }
    }
    return visited.size();
  }
}
