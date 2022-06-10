class Solution {
  public int findCircleNum(int[][] isConnected) {
    int n = isConnected.length;
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i != j && isConnected[i][j] == 1) {
          map.computeIfAbsent(i, k -> new HashSet<>()).add(j);
          map.computeIfAbsent(j, k -> new HashSet<>()).add(i);
        }
      }
    }
    Set<Integer> visited = new HashSet<>();
    int provinceCount = 0;
    for (int i = 0; i < n; i++) {
      if (!visited.contains(i)) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited.add(i);
        while (!queue.isEmpty()) {
          int removed = queue.remove();
          for (Integer connection : map.getOrDefault(removed, new HashSet<>())) {
            if (!visited.contains(connection)) {
              queue.add(connection);
              visited.add(connection);
            }
          }
        }
        provinceCount++;
      }
    }
    return provinceCount;
  }
}
