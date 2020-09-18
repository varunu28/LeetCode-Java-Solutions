class Solution {
  public String frequencySort(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    PriorityQueue<Character> pq = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));
    pq.addAll(map.keySet());
    StringBuilder sb = new StringBuilder();
    while (!pq.isEmpty()) {
      char c = pq.poll();
      int count  = map.get(c);
      while (count-- > 0) {
        sb.append(c);
      }
    }
    return sb.toString();
  }
}

