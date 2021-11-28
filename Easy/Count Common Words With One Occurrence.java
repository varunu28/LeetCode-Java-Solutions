class Solution {
  public int countWords(String[] words1, String[] words2) {
    Map<String, int[]> map = new HashMap<>();
    buildFrequencyMap(words1, map, 0);
    buildFrequencyMap(words2, map, 1);
    return (int) map.entrySet().stream()
        .filter(entry -> entry.getValue()[0] == 1 && entry.getValue()[1] == 1)
        .count();
  }

  private void buildFrequencyMap(String[] words, Map<String, int[]> map, int idx) {
    for (String word : words) {
      map.computeIfAbsent(word, k -> new int[2])[idx]++;
    }
  }
}
