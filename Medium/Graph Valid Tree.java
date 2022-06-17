class Solution {
  public boolean validTree(int n, int[][] edges) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int[] edge : edges) {
      map.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
      map.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
    }
    Map<Integer, Integer> parent = new HashMap<>();
    parent.put(0, -1);
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    while (!stack.isEmpty()) {
      int node = stack.pop();
      for (int neighbor : map.getOrDefault(node, new HashSet<>())) {
        if (parent.get(node) == neighbor) {
          continue;
        }
        if (parent.containsKey(neighbor)) {
          return false;
        }
        stack.push(neighbor);
        parent.put(neighbor, node);
      }
    }
    return parent.size() == n;
  }
}
