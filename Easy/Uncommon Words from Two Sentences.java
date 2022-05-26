class Solution {
  public String[] uncommonFromSentences(String s1, String s2) {
    Map<String, Integer> map = new HashMap<>();
    String[] wordsOne = s1.split("\\s+");
    for (String word : wordsOne) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }
    String[] wordsTwo = s2.split("\\s+");
    for (String word : wordsTwo) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }
    List<String> result = new ArrayList<>();
    for (String key : map.keySet()) {
      if (map.get(key) == 1) {
        result.add(key);
      }
    }
    return result.toArray(new String[]{});
  }
}
