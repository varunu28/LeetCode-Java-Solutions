class Solution {
  public List<String> stringMatching(String[] words) {
    List<String> list = new ArrayList<>();
    for (int i = 0; i < words.length; i++) {
      for (int j = 0; j < words.length; j++) {
        if (i != j && isSubstring(words[i], words[j])) {
          list.add(words[i]);
          break;
        }
      }
    }
    return list;
  }
  
  private boolean isSubstring(String s1, String s2) {
    if (s1.length() > s2.length()) {
      return false;
    }
    for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
      if (s2.substring(i, i + s1.length()).equals(s1)) {
        return true;
      }
    }
    return false;
  }
}
