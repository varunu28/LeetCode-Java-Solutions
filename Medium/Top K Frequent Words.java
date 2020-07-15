class Solution {
  public List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }
    PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>(){
      public int compare(String s1, String s2) {
        int c = map.get(s2) - map.get(s1);
        if (c != 0) {
          return c;
        }
        return s1.compareTo(s2);
      }
    });
    pq.addAll(map.keySet());
    List<String> ans = new ArrayList<>();
    while (!pq.isEmpty() && k-- > 0) {
      ans.add(pq.poll());
    }
    return ans;
  }
}
