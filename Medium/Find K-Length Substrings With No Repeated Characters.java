class Solution {
  public int numKLenSubstrNoRepeats(String s, int k) {
    if (s.length() < k) {
      return 0;
    }
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < k; i++) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    }
    int resultCount = 0;
    for (int i = k; i < s.length(); i++) {
      if (map.size() == k) {
        resultCount++;
      }
      int startIdx = i - k;
      map.put(s.charAt(startIdx), map.getOrDefault(s.charAt(startIdx), 0) - 1);
      if (map.get(s.charAt(startIdx)) == 0) {
        map.remove(s.charAt(startIdx));
      }
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    }
    return resultCount + (map.size() == k ? 1 : 0);
  }
}
