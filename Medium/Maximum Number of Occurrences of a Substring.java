class Solution {
  public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
    int n = s.length();
    if (minSize > n) {
      return 0;
    }
    Map<String, Integer> substringMap = new HashMap<>();
    for (int i = 0; i < n; i++) {
      Map<Character, Integer> charMap = new HashMap<>();
      for (int j = 0; j < maxSize; j++) {
        if (i + j >= n) {
          break;
        }       
        charMap.put(s.charAt(i + j), charMap.getOrDefault(s.charAt(i + j), 0) + 1);
        if (charMap.size() > maxLetters) {
          break;
        }
        if (j >= minSize - 1) {
          substringMap.put(
            s.substring(i, i + j + 1), substringMap.getOrDefault(s.substring(i, i + j + 1), 0) + 1
          );
        }
      }
    }
    int maxFreqCount = 0;
    for (String substr : substringMap.keySet()) {
      maxFreqCount = Math.max(maxFreqCount, substringMap.get(substr));
    }
    return maxFreqCount;
  }
}
