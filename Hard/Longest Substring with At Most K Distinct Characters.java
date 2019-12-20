class Solution {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    Map<Character, Integer> map = new HashMap<>();
    int slow = 0;
    int fast = 0;
    int n = s.length();
    int maxLength = 0;
    while (fast < n) {
      map.put(s.charAt(fast), map.getOrDefault(s.charAt(fast), 0) + 1);
      while (map.size() > k) {
        map.put(s.charAt(slow), map.getOrDefault(s.charAt(slow), 0) - 1);
        if (map.get(s.charAt(slow)) == 0) {
          map.remove(s.charAt(slow));
        }
        slow++;
      }
      fast++;
      maxLength = Math.max(maxLength, fast - slow);
    }
    return maxLength;
  }
}
