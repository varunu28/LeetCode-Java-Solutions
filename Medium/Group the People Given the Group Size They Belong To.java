class Solution {
  public List<List<Integer>> groupThePeople(int[] groupSizes) {
    Map<Integer, Queue<Integer>> groupSizeToId = new HashMap<>();
    for (int i = 0; i < groupSizes.length; i++) {
      groupSizeToId.computeIfAbsent(groupSizes[i], k -> new LinkedList<>()).add(i);
    }
    List<List<Integer>> result = new ArrayList<>();
    for (Integer groupSize : groupSizeToId.keySet()) {
      Queue<Integer> ids = groupSizeToId.get(groupSize);
      while (!ids.isEmpty()) {
        List<Integer> group = new ArrayList<>(groupSize);
        for (int i = 0; i< groupSize; i++) {
          group.add(ids.remove());
        }
        result.add(group);
      }
    }
    return result;
  }
}
