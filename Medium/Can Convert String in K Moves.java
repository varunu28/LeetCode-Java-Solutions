class Solution {
  public boolean canConvertString(String s, String t, int k) {
    if (s.length() != t.length()) {
      return false;
    }
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      int possibleMove = getDifference(s.charAt(i), t.charAt(i));
      if (possibleMove > 0 && (possibleMove + map.getOrDefault(possibleMove, 0) * 26) > k) {
        return false;
      }
      map.put(possibleMove, map.getOrDefault(possibleMove, 0) + 1);
    }
    return true;
  }
  
  private int getDifference(char c1, char c2) {
    int diff = ((int) c2) - ((int) c1);
    if (diff >= 0) {
      return diff;
    }
    return diff + 26;
  }
}
