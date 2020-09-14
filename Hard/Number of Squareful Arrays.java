class Solution {
  public int numSquarefulPerms(int[] A) {
    Map<Integer, Integer> count = new HashMap<>();
    Map<Integer, List<Integer>> graph = new HashMap<>();
    int n = A.length;
    for (int num : A) {
      count.put(num, count.getOrDefault(num, 0) + 1);
    }
    for (Integer key1 : count.keySet()) {
      graph.computeIfAbsent(key1, k -> new ArrayList<>());
      for (Integer key2 : count.keySet()) {
        int r = (int) (Math.sqrt(key1 + key2) + 0.5);
        if (r * r == key1 + key2) {
          graph.get(key1).add(key2);
        }
      }
    }
    int ans = 0;
    for (Integer key : count.keySet()) {
      ans += dfs(key, n - 1, count, graph);
    }
    return ans;
  }
  
  private int dfs(int key, int toReach, Map<Integer, Integer> count, Map<Integer, List<Integer>> graph) {
    count.put(key, count.get(key) - 1);
    int currAns = 1;
    if (toReach != 0) {
      currAns = 0;
      for (int node : graph.get(key)) {
        if (count.get(node) != 0) {
          currAns += dfs(node, toReach - 1, count, graph);
        }
      }
    }
    count.put(key, count.get(key) + 1);
    return currAns;
  }
}
