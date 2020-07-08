class Solution {
  List<String> result = null;
  public List<String> findItinerary(List<List<String>> tickets) {
    Map<String, List<String>> map = new HashMap<>();
    Map<String, boolean[]> visitMap = new HashMap<>();
    int flights = tickets.size();
    for (List<String> ticket : tickets) {
      map.computeIfAbsent(ticket.get(0), k -> new ArrayList<>()).add(ticket.get(1));
    }
    for (Map.Entry<String, List<String>> entry : map.entrySet()) {
      Collections.sort(entry.getValue());
      visitMap.put(entry.getKey(), new boolean[entry.getValue().size()]);
    }
    LinkedList<String> route = new LinkedList<String>();
    route.add("JFK");
    backtrack(map, visitMap, flights, route, "JFK");
    return result;
  }
  
  private boolean backtrack(
    Map<String, List<String>> map,
    Map<String, boolean[]> visitMap,
    int flights,
    LinkedList<String> route,
    String origin
  ) {
    if (route.size() == (flights + 1)) {
      result = (List<String>) route.clone();
      return true;
    }
    if (!map.containsKey(origin)) {
      return false;
    }
    int i = 0;
    boolean[] visited = visitMap.get(origin);
    for (String dest : map.get(origin)) {
      if (!visited[i]) {
        visited[i] = true;
        route.add(dest);
        boolean res = backtrack(map, visitMap, flights, route, dest);
        route.pollLast();
        visited[i] = false;
        if (res == true) {
          return true;
        }
      }
      i++;
    }
    return false;
  }
}
