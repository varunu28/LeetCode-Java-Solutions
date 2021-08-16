class Solution {
  public String minWindow(String s, String t) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : t.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    int count = map.size();
    int start = 0;
    int end = 0;
    int minWindowLength = Integer.MAX_VALUE;
    int minWindowStart = 0;
    int minWindowEnd = 0;
    while (end < s.length()) {
      char c = s.charAt(end++);
      if (map.containsKey(c)) {
        map.put(c, map.get(c) - 1);
        if (map.get(c) == 0) {
          count--;
        }
      }
      while (count == 0 && start < end) {
        if (end - start < minWindowLength) {
          minWindowLength = end - start;
          minWindowStart = start;
          minWindowEnd = end;
        }
        char temp = s.charAt(start++);
        if (map.containsKey(temp)) {
          map.put(temp, map.get(temp) + 1);
          if (map.get(temp) == 1) {
            count++;
          }
        }
      }
    }
    return s.substring(minWindowStart, minWindowEnd);
  }
}
