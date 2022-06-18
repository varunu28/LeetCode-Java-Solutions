class Solution {
  public boolean isIsomorphic(String s, String t) {
    int[] position = new int[512];
    for (int i = 0; i < s.length(); i++) {
      if (position[s.charAt(i)] != position[t.charAt(i) + 256]) {
        return false;
      }
      position[s.charAt(i)] = position[t.charAt(i) + 256] = i + 1;
    }
    return true;
  }
}
