class Solution {
  public int treeDiameter(int[][] edges) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int[] edge : edges) {
      graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
      graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
    }
    int farthestNode = bfsHelper(graph, 0)[0];
    return bfsHelper(graph, farthestNode)[1];
  }

  private int[] bfsHelper(Map<Integer, List<Integer>> graph, int node) {
    int farthestNode = 0;
    int steps = 0;
    Queue<Integer> queue = new LinkedList<>();
    queue.add(node);
    Set<Integer> visited = new HashSet<>();
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size--  > 0) {
        int removedNode = queue.remove();
        visited.add(removedNode);
        farthestNode = removedNode;
        for (Integer peer : graph.getOrDefault(removedNode, new ArrayList<>())) {
          if (!visited.contains(peer)) {
            queue.add(peer);
          }
        }
      }
      if (!queue.isEmpty()) {
        steps++;
      }
    }
    return new int[]{farthestNode, steps};
  }
}
