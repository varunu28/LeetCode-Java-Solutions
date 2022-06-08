class Solution {
  public int longestPalindrome(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    int totalLength = 0;
    boolean oddTaken = false;
    for (Character key : map.keySet()) {
      totalLength += (map.get(key) / 2) * 2;
      if (!oddTaken && map.get(key) % 2 != 0) {
        totalLength++;
        oddTaken = !oddTaken;
      }
    }
    return totalLength;
  }
}
