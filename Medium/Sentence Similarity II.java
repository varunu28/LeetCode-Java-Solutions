class Solution {
  public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
    if (words1.length != words2.length) {
      return false;
    }
    Map<String, Set<String>> map = new HashMap<>();
    for (List<String> pair : pairs) {
      String word1 = pair.get(0);
      String word2 = pair.get(1);
      map.computeIfAbsent(word1, k -> new HashSet<>()).add(word2);
      map.computeIfAbsent(word2, k -> new HashSet<>()).add(word1);
    }
    
    for (int i = 0; i < words1.length; i++) {
      String start = words1[i];
      String end = words2[i];
      if (!dfs(map, start, end)) {
        return false;
      }
    }
    return true;
  }
  
  private boolean dfs(Map<String, Set<String>> map, String start, String end) {
    Queue<String> queue = new LinkedList<>();
    Set<String> set = new HashSet<>();
    queue.add(start);
    set.add(start);
    while (!queue.isEmpty()) {
      String removed = queue.remove();
      if (removed.equals(end)) {
        return true;
      }
      for (String similar : map.getOrDefault(removed, new HashSet<>())) {
        if (!set.contains(similar)) {
          queue.add(similar);
          set.add(similar);
        }
      }
    }
    return false;
  }
}
