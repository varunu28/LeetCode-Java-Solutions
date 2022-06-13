class Solution {
  public int networkDelayTime(int[][] times, int n, int k) {
    Map<Integer, List<TimeNode>> map = new HashMap<>();
    for (int[] time : times) {
      map.computeIfAbsent(time[0], j -> new ArrayList<>()).add(new TimeNode(time[1], time[2]));
    }
    PriorityQueue<TimeNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.time));
    pq.add(new TimeNode(k, 0));
    int maxTime = 0;
    Set<Integer> visited = new HashSet<>();
    visited.add(k);
    while (!pq.isEmpty() && visited.size() < n) {
      TimeNode removed = pq.remove();
      visited.add(removed.node);
      maxTime = Math.max(maxTime, removed.time);
      for (TimeNode conn : map.getOrDefault(removed.node, new ArrayList<>())) {
        if (visited.contains(conn.node)) {
          continue;
        }
        pq.add(new TimeNode(conn.node, removed.time + conn.time));
      }
    }
    return visited.size() == n ? maxTime : -1;
  }
  
  class TimeNode {
    int node;
    int time;
    
    public TimeNode(int node, int time) {
      this.node = node;
      this.time = time;
    }
  }
}
