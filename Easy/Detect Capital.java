class Solution {
  public boolean detectCapitalUse(String word) {
    boolean firstUpperCase = Character.isUpperCase(word.charAt(0));
    boolean allUpperCase = false;
    for (int i = 1; i < word.length(); i++) {
      if (Character.isUpperCase(word.charAt(i))) {
        if (!firstUpperCase) {
          return false;
        }
        if (i == 1) {
          allUpperCase = true;
        } else {
          if (!allUpperCase) {
            return false;
          }
        }
      } else {
        if (allUpperCase) {
          return false;
        }
      }
    }
    return true;
  }
}
