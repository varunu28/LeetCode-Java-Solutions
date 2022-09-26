class Solution {
  public boolean equationsPossible(String[] equations) {
    List<Integer>[] graph = new ArrayList[26];
    for (int i = 0; i < 26; i++) {
      graph[i] = new ArrayList<>();
    }
    for (String equation : equations) {
      if (equation.charAt(1) == '=') {
        int first = equation.charAt(0) - 'a';
        int second = equation.charAt(3) - 'a';
        graph[first].add(second);
        graph[second].add(first);
      }
    }
    int[] color = new int[26];
    Arrays.fill(color, -1);
    for (int i = 0; i < 26; i++) {
      if (color[i] == -1) {
        dfs(i, i, color, graph);
      }
    }
    for (String equation : equations) {
      if (equation.charAt(1) == '!') {
        int first = equation.charAt(0) - 'a';
        int second = equation.charAt(3) - 'a';
        if (color[first] == color[second]) {
          return false;
        }
      }
    }
    return true;
  }
  
  private static void dfs(int node, int nodeColor, int[] color, List<Integer>[] graph) {
    if (color[node] == -1) {
      color[node] = nodeColor;
      for (int neighbor : graph[node]) {
        dfs(neighbor, nodeColor, color, graph);
      }
    }
  }
}
