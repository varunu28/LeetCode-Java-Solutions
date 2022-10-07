class Solution {
  public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
    Map<Character, Integer> letterFrequencyMap = new HashMap<>();
    Map<String, Integer> substringFrequencyMap = new HashMap<>();
    int start = 0;
    int maxCount = 0;
    for (int i = 0; i < s.length(); i++) {
      letterFrequencyMap.put(s.charAt(i), letterFrequencyMap.getOrDefault(s.charAt(i), 0) + 1);
      while (i - start + 1 > minSize || letterFrequencyMap.size() > maxLetters) {
        letterFrequencyMap.put(s.charAt(start), letterFrequencyMap.getOrDefault(s.charAt(start), 0) - 1);
        if (letterFrequencyMap.get(s.charAt(start)) == 0) {
          letterFrequencyMap.remove(s.charAt(start));
        }
        start++;
      }
      if (i - start + 1 == minSize) {
        String currSubstring = s.substring(start, i + 1);
        substringFrequencyMap.put(currSubstring, substringFrequencyMap.getOrDefault(currSubstring, 0) + 1);
        maxCount = Math.max(maxCount, substringFrequencyMap.get(currSubstring));
      }
    }
    return maxCount;
  }
}
