class Solution {
  public int findTheCity(int n, int[][] edges, int distanceThreshold) {
    Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
    for (int[] edge : edges) {
      map.computeIfAbsent(edge[0], k -> new HashMap<>()).put(edge[1], edge[2]);
      map.computeIfAbsent(edge[1], k -> new HashMap<>()).put(edge[0], edge[2]);
    }
    int min = n + 1;
    int res = -1;
    for (int i = 0; i < n; i++) {
      Queue<int[]> queue = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
      queue.add(new int[]{i, distanceThreshold});
      boolean[] visited = new boolean[n];
      int count = 0;
      while (!queue.isEmpty()) {
        int[] city = queue.poll();
        if (visited[city[0]]) {
          continue;
        }
        visited[city[0]] = true;
        count++;
        Map<Integer, Integer> temp = map.getOrDefault(city[0], new HashMap<>());
        for (Integer neighbour : temp.keySet()) {
          if (!visited[neighbour] && city[1] >= temp.get(neighbour)) {
            queue.add(new int[]{neighbour, city[1] - temp.get(neighbour)});
          }
        }
      }
      if (count - 1 <= min) {
        min = count - 1;
        res = i;
      }
    }
    return res;
  }
}

