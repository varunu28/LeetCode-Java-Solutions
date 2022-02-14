class Solution {
  public int networkDelayTime(int[][] times, int n, int k) {
    // Mapping from node to all outgoing edges alongside weight of each edge
    Map<Integer, List<int[]>> map = new HashMap<>();
    for (int[] time : times) {
      map.computeIfAbsent(time[0], j -> new ArrayList<>()).add(new int[] {time[1], time[2]});
    }
    // Min heap in order of edge weight
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
    priorityQueue.add(new int[] {0, k});
    Set<Integer> visited = new HashSet<>();
    int totalTime = 0;
    while (!priorityQueue.isEmpty()) {
      int[] removed = priorityQueue.poll();
      int currNode = removed[1];
      int edgeWeight = removed[0];
      if (visited.contains(currNode)) {
        continue;
      }
      visited.add(currNode);
      totalTime = Math.max(totalTime, edgeWeight);
      for (int[] neighbor : map.getOrDefault(removed[1], new ArrayList<>())) {
        int neighborNode = neighbor[0];
        int neighborEdgeWeight = neighbor[1];
        if (!visited.contains(neighborNode)) {
          priorityQueue.add(new int[] {neighborEdgeWeight + edgeWeight, neighborNode});
        }
      }
    }
    return visited.size() == n ? totalTime : -1;
  }
}
