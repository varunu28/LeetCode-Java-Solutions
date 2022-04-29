class Solution {
  public boolean isBipartite(int[][] graph) {
    int n = graph.length;
    int[] color = new int[n];
    Arrays.fill(color, -1);
    for (int i = 0; i < n; i++) {
      if (color[i] == -1 && !bipartiteCheck(graph, i, color)) {
        return false;
      }
    }
    return true;
  }
  
  private boolean bipartiteCheck(int[][] graph, int node, int[] color) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(node);
    int currColor = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int removed = queue.remove();
        if (color[removed] != -1) {
          if (color[removed] != currColor) {
            return false;
          }
          continue;
        }
        color[removed] = currColor;
        for (int conn : graph[removed]) {
          if (color[conn] == -1) {
            queue.add(conn);
          }
        }
      }
      currColor = currColor == 1 ? 0 : 1;
    }
    return true;
  }
}
