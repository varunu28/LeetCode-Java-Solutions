class Solution {
  public char repeatedCharacter(String s) {
    boolean[] seen = new boolean[26];
    for (char c : s.toCharArray()) {
      if (seen[c - 'a']) {
        return c;
      }
      seen[c - 'a'] = true;
    }
    return ' ';
  }
}
