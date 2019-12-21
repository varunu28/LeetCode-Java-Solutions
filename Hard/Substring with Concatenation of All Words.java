class Solution {
  public List<Integer> findSubstring(String s, String[] words) {
    if (s.length() == 0 || words.length == 0) {
      return new ArrayList<>();
    }
    Map<String, Integer> wordFreqMap = new HashMap<>();
    for (String word : words) {
      wordFreqMap.put(word, wordFreqMap.getOrDefault(word, 0) + 1);
    }
    int stringLength = s.length();
    int wordCount = words.length;
    int singleWordLength = words[0].length();
    List<Integer> indices = new ArrayList<>();
    for (int i = 0; i + singleWordLength * wordCount <= stringLength; i++) {
      if (match(s, i, singleWordLength, wordFreqMap, wordCount)) {
        indices.add(i);
      }
    }
    return indices;
  }
  
  private boolean match(String s, int start, int singleWordLength, Map<String, Integer> wordFreqMap, int wordCount) {
    Map<String, Integer> currFreqMap = new HashMap<>();
    for (int i = 0; i < wordCount; i++) {
      String currWord = s.substring(start + i * singleWordLength, start + (i + 1) * singleWordLength);
      Integer freq = wordFreqMap.get(currWord);
      // Word not in required words
      if (freq == null) { 
        return false;
      }
      currFreqMap.put(currWord, currFreqMap.getOrDefault(currWord, 0) + 1);
      // Word occurs more than the required count
      if (currFreqMap.get(currWord) > freq) {
        return false;
      }
    }
    return true;
  }
}
