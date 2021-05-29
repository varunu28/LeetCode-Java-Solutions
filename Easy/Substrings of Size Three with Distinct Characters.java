class Solution {
  public int countGoodSubstrings(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int count = 0;
    for (int i = 0; i < Math.min(s.length(), 2); i++) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    }
    for (int i = 2; i < s.length(); i++) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
      if (map.size() == 3) {
        count++;
      }
      map.put(s.charAt(i - 2), map.getOrDefault(s.charAt(i - 2), 0) - 1);
      if (map.get(s.charAt(i - 2)) == 0) {
        map.remove(s.charAt(i - 2));
      }
    }
    return count;
  }
}
