class Solution {
  public int findTheCity(int n, int[][] edges, int distanceThreshold) {
    Map<Integer, List<int[]>> graph = new HashMap<>();
    for (int[] edge : edges) {
      graph.computeIfAbsent(edge[0], k -> new ArrayList<>())
          .add(new int[]{edge[1], edge[2]});
      graph.computeIfAbsent(edge[1], k -> new ArrayList<>())
          .add(new int[]{edge[0], edge[2]});
    }
    int minNeighborCount = n + 1;
    int nodeWithMinNeighbor = -1;
    for (int i = 0; i < n; i++) {
      int numOfNeighbors = findNumberOfNeighborsWithinThresholdDistance(i, distanceThreshold, graph);
      minNeighborCount = Math.min(numOfNeighbors, minNeighborCount);
      nodeWithMinNeighbor = minNeighborCount == numOfNeighbors ? i : nodeWithMinNeighbor;
    }
    return nodeWithMinNeighbor;
  }

  private int findNumberOfNeighborsWithinThresholdDistance(int node, int distanceThreshold, Map<Integer, List<int[]>> graph) {
    Queue<int[]> queue = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
    Set<Integer> visited = new HashSet<>();
    queue.add(new int[]{node, distanceThreshold});
    int numOfNeighbors = 0;
    while (!queue.isEmpty()) {
      int[] removed = queue.remove();
      int currNode = removed[0];
      int currDistanceThreshold = removed[1];
      if (visited.contains(currNode)) {
        continue;
      }
      visited.add(currNode);
      numOfNeighbors++;
      for (int[] neighbor : graph.getOrDefault(currNode, new ArrayList<>())) {
        int neighborNode = neighbor[0];
        int neighborDistance = neighbor[1];
        if (!visited.contains(neighborNode) &&
            currDistanceThreshold >= neighborDistance) {
          queue.add(new int[]{neighborNode, currDistanceThreshold - neighborDistance});
        }
      }
    }
    return numOfNeighbors;
  }
}
