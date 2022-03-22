class Solution {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    Map<Character, Integer> map = new HashMap<>();
    int startIdx = 0;
    int endIdx = 0;
    int maxLength = 0;
    while (endIdx < s.length()) {
      map.put(s.charAt(endIdx), map.getOrDefault(s.charAt(endIdx), 0) + 1);
      endIdx++;
      while (startIdx < endIdx && map.size() > k) {
        map.put(s.charAt(startIdx), map.getOrDefault(s.charAt(startIdx), 0 ) - 1);
        if (map.get(s.charAt(startIdx))  == 0) {
          map.remove(s.charAt(startIdx));
        }
        startIdx++;
      }
      maxLength = Math.max(maxLength, endIdx - startIdx);
    }
    return maxLength;
  }
}
