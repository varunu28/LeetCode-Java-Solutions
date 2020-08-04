class Solution {
  enum State { 
    PROCESSING, 
    PROCESSED 
  }
  
  public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    for (int[] edge : edges) {
      graph.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
    }
    return leadsToDestinationHelper(graph, source, destination, new State[n]);
  }
  
  private boolean leadsToDestinationHelper(
    Map<Integer, Set<Integer>> graph, int source, int destination, State[] states
  ) {
    if (states[source] != null) {
      return states[source] == State.PROCESSED;
    }
    if (!graph.containsKey(source)) {
      return source == destination;
    }
    states[source] = State.PROCESSING;
    for (Integer child : graph.getOrDefault(source, new HashSet<>())) {
      if (!leadsToDestinationHelper(graph, child, destination, states)) {
        return false;
      }
    }
    states[source] = State.PROCESSED;
    return true;
  }
}
