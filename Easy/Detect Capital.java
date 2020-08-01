class Solution {
  public boolean detectCapitalUse(String word) {
    int n = word.length();
    if (n == 0) {
      return true;
    }
    boolean firstCaps = Character.isUpperCase(word.charAt(0));
    for (int i = 1; i < n; i++) {
      if (firstCaps) {
        if (Character.isUpperCase(word.charAt(1)) && !Character.isUpperCase(word.charAt(i))) {
          return false;
        }
        if (!Character.isUpperCase(word.charAt(1)) && Character.isUpperCase(word.charAt(i))) {
          return false;
        }
      }
      else {
        if (Character.isUpperCase(word.charAt(i))) {
          return false;
        }
      }
    }
    return true;
  }
}
