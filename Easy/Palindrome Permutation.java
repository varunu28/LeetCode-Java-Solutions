class Solution {
  public boolean canPermutePalindrome(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    boolean oddFound = false;
    for (Character key : map.keySet()) {
      if (map.get(key) % 2 != 0) {
        if (oddFound) {
          return false;
        }
        oddFound = true;
      }
    }
    return true;
  }
}
