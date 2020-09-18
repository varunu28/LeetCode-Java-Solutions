class Solution {
  public int networkDelayTime(int[][] times, int N, int K) {
    Map<Integer, List<Connection>> map = new HashMap<>();
    for (int[] time : times) {
      map.computeIfAbsent(time[0], k -> new ArrayList<>()).add(new Connection(time[1], time[2]));
    }
    Map<Integer, Integer> dist = new HashMap<>();
    for (int node = 1; node <= N; node++) {
      dist.put(node, Integer.MAX_VALUE);
    }
    dist.put(K, 0);
    boolean[] seen = new boolean[N + 1];
    while (true) {
      int candNode = -1;
      int candDist = Integer.MAX_VALUE;
      for (int i = 1; i <= N; ++i) {
        if (!seen[i] && dist.get(i) < candDist) {
          candDist = dist.get(i);
          candNode = i;
        }
      }
      if (candNode < 0) {
        break;
      }
      seen[candNode] = true;
      for (Connection con: map.getOrDefault(candNode, new ArrayList<>())) {
        dist.put(con.val, Math.min(dist.get(con.val), dist.get(candNode) + con.time));
      }
    }
    int ans = 0;
    for (int cand: dist.values()) {
      if (cand == Integer.MAX_VALUE) {
        return -1;
      }
      ans = Math.max(ans, cand);
    }
    return ans;
  }
}

class Connection {
  int val;
  int time;
  
  public Connection(int val, int time) {
    this.val = val;
    this.time = time;
  }
}
