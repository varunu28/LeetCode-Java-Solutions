class Solution {
  public int[] restoreArray(int[][] adjacentPairs) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int[] pair : adjacentPairs) {
      map.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
      map.computeIfAbsent(pair[1], k -> new ArrayList<>()).add(pair[0]);
    }
    int head = map.keySet().stream().filter(k -> map.get(k).size() == 1).findFirst().orElse(-1);
    Set<Integer> visited = new HashSet<>();
    int[] result = new int[map.size()];
    int idx = 0;
    Queue<Integer> queue = new LinkedList<>();
    queue.add(head);
    while (!queue.isEmpty()) {
      int removed = queue.remove();
      if (visited.contains(removed)) {
        continue;
      }
      result[idx++] = removed;
      visited.add(removed);
      queue.addAll(map.get(removed));
    }
    return result;
  }
}
