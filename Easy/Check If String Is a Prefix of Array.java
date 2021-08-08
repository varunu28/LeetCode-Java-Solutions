class Solution {
  public boolean isPrefixString(String s, String[] words) {
    int idx = 0;
    for (String word : words) {
      for (int i = 0; i < word.length(); i++) {
        if (word.charAt(i) != s.charAt(idx)) {
          return false;
        }
        idx++;
        if (idx == s.length()) {
          return i == word.length() - 1;
        }
      }
    }
    return idx == s.length();
  }   
}
