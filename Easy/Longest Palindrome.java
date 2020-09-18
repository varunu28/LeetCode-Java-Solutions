class Solution {
  public int longestPalindrome(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    int count = 0;
    boolean oddTaken = false;
    for (Character key : map.keySet()) {
      int val = map.get(key);
      count += (val / 2) * 2;
      if ((val == 1 || val % 2 != 0) && !oddTaken) {
        oddTaken = true;
        count++;
      }
    }
    return count;
  }
}
