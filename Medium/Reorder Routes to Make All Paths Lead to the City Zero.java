class Solution {
  public int minReorder(int n, int[][] connections) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    Set<String> set = new HashSet<>();
    for (int[] connection : connections) {
      map.computeIfAbsent(connection[0], k -> new HashSet<>()).add(connection[1]);
      map.computeIfAbsent(connection[1], k -> new HashSet<>()).add(connection[0]);
      set.add(connection[0] + "->" + connection[1]);
    }
    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);
    int numOfReorders = 0;
    boolean[] visited = new boolean[n];
    visited[0] = true;
    while (!queue.isEmpty()) {
      int removed = queue.remove();
      for (int connection : map.getOrDefault(removed, new HashSet<>())) {
        if (visited[connection]) {
          continue;
        }
        visited[connection] = true;
        if (!set.contains(connection + "->" + removed)) {
          numOfReorders++;
        }
        queue.add(connection);
      }
    }
    return numOfReorders;
  }
}
