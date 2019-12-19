class Solution {
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    if (n == 1) {
      return Collections.singletonList(0);
    }
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int[] edge: edges) {
      map.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
      map.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
    }
    List<Integer> leaves = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (map.getOrDefault(i, new HashSet<>()).size() == 1) {
        leaves.add(i);
      }
    }
    int count = n;
    while (count > 2) {
      int size = leaves.size();
      count -= size;
      List<Integer> newLeaves = new ArrayList<>();
      for (int leaf : leaves) {
        for (int toRemove : map.getOrDefault(leaf, new HashSet<>())) {
          map.get(toRemove).remove(leaf);
          if (map.get(toRemove).size() == 1) {
            newLeaves.add(toRemove);
          }
        }
      }
      leaves = newLeaves;
    }
    return leaves;
  }
}
