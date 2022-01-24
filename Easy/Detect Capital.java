class Solution {
  public boolean detectCapitalUse(String word) {
    boolean firstCapital = Character.isUpperCase(word.charAt(0));
    for (int i = 1; i < word.length(); i++) {
      if (Character.isUpperCase(word.charAt(i))) {
        if (!firstCapital || !firstTwoCharactersCapital(word)) {
          return false;
        }
      } else {
        if (i > 1 && firstTwoCharactersCapital(word)) {
          return false;
        }
      }
    }
    return true;
  }
  
  private boolean firstTwoCharactersCapital(String word) {
    return Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1));
  }
}
