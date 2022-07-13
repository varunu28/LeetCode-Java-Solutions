class Solution {
  public boolean isPalindrome(String s) {
    int startIdx = 0;
    int endIdx = s.length() - 1;
    while (startIdx < endIdx) {
      if (!isAlphanumeric(s.charAt(startIdx))) {
        startIdx++;
      } else if (!isAlphanumeric(s.charAt(endIdx))) {
        endIdx--;
      } else {
        if (!areSame(s.charAt(startIdx), s.charAt(endIdx))) {
          return false;
        }
        startIdx++;
        endIdx--;
      }
    }
    return true;
  }
  
  private boolean areSame(char c1, char c2) {
    if (Character.isAlphabetic(c1) && Character.isAlphabetic(c2)) {
      return Character.toLowerCase(c1) == Character.toLowerCase(c2);
    } else if (Character.isDigit(c1) && Character.isDigit(c2)) {
      return c1 == c2;
    } else {
      return false;
    }
  }

  private boolean isAlphanumeric(char c) {
    return Character.isAlphabetic(c) || Character.isDigit(c);
  }
}
