import java.util.Map.Entry;

class Solution {
  public int findCenter(int[][] edges) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int[] edge : edges) {
      map.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
      map.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
    }
    return map.entrySet().stream().filter(entry -> entry.getValue().size() == edges.length).map(
        Entry::getKey).findFirst().orElse(-1);
  }
}
