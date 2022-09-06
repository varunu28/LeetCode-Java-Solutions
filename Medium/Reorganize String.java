class Solution {
  public String reorganizeString(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    PriorityQueue<Character> pq = new PriorityQueue<>(
        (o1, o2) -> map.get(o2).compareTo(map.get(o1)));
    pq.addAll(map.keySet());
    StringBuilder sb = new StringBuilder();
    while (!pq.isEmpty()) {
      char removed = pq.poll();
      if (!sb.isEmpty() && sb.charAt(sb.length() - 1) == removed) {
        if (pq.isEmpty()) {
          return "";
        }
        char secondRemoved = pq.poll();
        pq.add(removed);
        sb.append(secondRemoved);
        updateStructure(map, pq, secondRemoved);
      } else {
        sb.append(removed);
        updateStructure(map, pq, removed);
      }
    }
    return sb.toString();
  }

  private void updateStructure(Map<Character, Integer> map, PriorityQueue<Character> pq, char c) {
    map.put(c, map.get(c) - 1);
    if (map.get(c) > 0) {
      pq.add(c);
    } else {
      map.remove(c);
    }
  }
}
