class Solution {
  public boolean isBipartite(int[][] graph) {
    int n = graph.length;
    int[] color = new int[n];
    Arrays.fill(color, -1);
    for (int i = 0; i < n; i++) {
      if (color[i] == -1) {
        Stack<Integer> stack = new Stack<>();
        stack.push(i);
        color[i] = 0;
        while (!stack.isEmpty()) {
          Integer node = stack.pop();
          for (Integer neighbor : graph[node]) {
            if (color[neighbor] == -1) {
              stack.push(neighbor);
              color[neighbor] = color[node] ^ 1;
            }
            else if (color[neighbor] == color[node]) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }
}
