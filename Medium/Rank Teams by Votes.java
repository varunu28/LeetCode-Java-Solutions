class Solution {
  public String rankTeams(String[] votes) {
    Map<Character, Map<Integer, Integer>> map = new HashMap<>();
    int positionCount = votes[0].length();
    for (String vote : votes) {
      for (int i = 0; i < vote.length(); i++) {
        char c = vote.charAt(i);
        map.computeIfAbsent(c, k -> new HashMap<>());
        map.get(c).put(i, map.get(c).getOrDefault(i, 0) + 1);
      }
    }
    PriorityQueue<Character> priorityQueue = new PriorityQueue<>((o1, o2) -> {
      for (int i = 0; i < positionCount; i++) {
        int c = map.get(o2).getOrDefault(i, 0) - map.get(o1).getOrDefault(i, 0);
        if (c != 0) {
          return c;
        }
      }
      return o1 - o2;
    });
    priorityQueue.addAll(map.keySet());
    StringBuilder sb = new StringBuilder();
    while (!priorityQueue.isEmpty()) {
      sb.append(priorityQueue.poll());
    }
    return sb.toString();
  }
}
