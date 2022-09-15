class Solution {
  public List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> wordFrequency = new HashMap<>();
    Map<Integer, Set<String>> frequencyToWord = new HashMap<>();
    int maxFrequency = 0;
    for (String word : words) {
      if (!wordFrequency.containsKey(word)) {
        wordFrequency.put(word, 1);
        frequencyToWord.computeIfAbsent(1, j -> new HashSet<>()).add(word);
      } else {
        int oldFrequency = wordFrequency.get(word);
        int newFrequency = oldFrequency + 1;
        wordFrequency.put(word, newFrequency);
        frequencyToWord.get(oldFrequency).remove(word);
        frequencyToWord.computeIfAbsent(newFrequency, j -> new HashSet<>()).add(word);
      }
      maxFrequency = Math.max(maxFrequency, wordFrequency.get(word));
    }
    List<String> result = new ArrayList<>();
    for (int i = maxFrequency; i > 0 && result.size() < k; i--) {
      List<String> currFreqWords = new ArrayList<>(frequencyToWord.get(i));
      Collections.sort(currFreqWords);
      for (int j = 0; j < currFreqWords.size() && result.size() < k; j++) {
        result.add(currFreqWords.get(j));
      }
    }
    return result;
  }
}
