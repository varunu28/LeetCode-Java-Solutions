class Solution {
  public String shortestCompletingWord(String licensePlate, String[] words) {
    int shortestWordIdx = -1;
    Map<Character, Integer> licensePlateFrequency = getFrequencyMap(licensePlate);
    for (int i = 0; i < words.length; i++) {
      if (canComplete(licensePlateFrequency, words[i])) {
        if (shortestWordIdx == -1 || words[i].length() < words[shortestWordIdx].length()) {
          shortestWordIdx = i;
        }
      }
    }
    return words[shortestWordIdx];
  }

  private boolean canComplete(Map<Character, Integer> licensePlateFrequency, String word) {
    Map<Character, Integer> wordFrequency = getFrequencyMap(word);
    for (Character key : licensePlateFrequency.keySet()) {
      if (wordFrequency.getOrDefault(key, 0) < licensePlateFrequency.get(key)) {
        return false;
      }
    }
    return true;
  }

  private Map<Character, Integer> getFrequencyMap(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      if (Character.isLetter(c)) {
        map.put(Character.toLowerCase(c), map.getOrDefault(Character.toLowerCase(c), 0) + 1);
      }
    }
    return map;
  }
}
