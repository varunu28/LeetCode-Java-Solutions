class Solution {
  List<String> result = null;
  public List<String> findItinerary(List<List<String>> tickets) {
    Map<String, List<String>> map = new HashMap<>();
    int flights = tickets.size();
    for (List<String> ticket : tickets) {
      map.computeIfAbsent(ticket.get(0), k -> new ArrayList<>()).add(ticket.get(1));
    }
    Map<String, boolean[]> visited = new HashMap<>();
    for (Map.Entry<String, List<String>> entry : map.entrySet()) {
      Collections.sort(entry.getValue());
      visited.put(entry.getKey(), new boolean[entry.getValue().size()]);
    }
    LinkedList<String> route = new LinkedList<String>();
    route.add("JFK");
    backtrack(map, visited, flights, route, "JFK");
    return result;
  }
  
  private boolean backtrack(
    Map<String, List<String>> map,
    Map<String, boolean[]> visited,
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
    boolean[] visit = visited.get(origin);
    for (int i = 0; i < map.get(origin).size(); i++) {
      if (!visit[i]) {
        visit[i] = true;
        route.add(map.get(origin).get(i));
        boolean res = backtrack(map, visited, flights, route, map.get(origin).get(i));
        route.pollLast();
        visit[i] = false;
        if (res) {
          return res;
        }
      }
    }
    return false;
  }
}
