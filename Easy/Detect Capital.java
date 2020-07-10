class Solution {
  public boolean detectCapitalUse(String word) {
    int n = word.length();
    boolean capitalFirst = Character.isUpperCase(word.charAt(0));
    int idx = 1;
    if (idx < n) {
      boolean capitalSecond = Character.isUpperCase(word.charAt(idx));
      for (idx = 1; idx < n; idx++) {
        if (capitalFirst && capitalSecond) {
          if (Character.isLowerCase(word.charAt(idx))) {
            return false;
          }
        }
        else if (capitalFirst && !capitalSecond) {
          if (Character.isUpperCase(word.charAt(idx))) {
            return false;
          }
        }
        else {
          if (Character.isUpperCase(word.charAt(idx))) {
            return false;
          }
        }
      }
    }
    return true;
  }
}
