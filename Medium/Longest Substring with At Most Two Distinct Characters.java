class Solution {
  public int lengthOfLongestSubstringTwoDistinct(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int startIdx = 0;
    int endIdx = 0;
    int n = s.length();
    int maxLength = 0;
    while (endIdx < n) {
      map.put(s.charAt(endIdx), map.getOrDefault(s.charAt(endIdx), 0) + 1);
      while (startIdx < endIdx && map.size() > 2) {
        map.put(s.charAt(startIdx), map.getOrDefault(s.charAt(startIdx), 0) - 1);
        if (map.get(s.charAt(startIdx)) <= 0) {
          map.remove(s.charAt(startIdx));
        }
        startIdx++;
      }
      endIdx++;
      maxLength = Math.max(endIdx - startIdx, maxLength);
    }
    return maxLength;
  }
}
