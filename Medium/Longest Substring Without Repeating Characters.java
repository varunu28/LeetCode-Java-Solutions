class Solution {
  public int lengthOfLongestSubstring(String s) {
    int start = 0;
    int end = 0;
    int n = s.length();
    Map<Character, Integer> map = new HashMap<>();
    int maxLength = 0;
    while (end < n) {
      char c = s.charAt(end++);
      map.put(c, map.getOrDefault(c, 0) + 1);
      while (start <= end && map.get(c) > 1) {
        map.put(s.charAt(start), map.getOrDefault(s.charAt(start++), 0) - 1);
      }
      maxLength = Math.max(maxLength, end - start);
    }
    return maxLength;
  }
}
