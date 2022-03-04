class Solution {
  public boolean isPalindrome(String s) {
    int startIdx = 0;
    int endIdx = s.length() - 1;
    while (startIdx < endIdx) {
      if (!Character.isLetterOrDigit(s.charAt(startIdx))) {
        startIdx++;
        continue;
      }
      if (!Character.isLetterOrDigit(s.charAt(endIdx))) {
        endIdx--;
        continue;
      }
      char startChar = Character.isDigit(s.charAt(startIdx)) ? s.charAt(startIdx) : Character.toLowerCase(s.charAt(startIdx));
      char endChar = Character.isDigit(s.charAt(endIdx)) ? s.charAt(endIdx) : Character.toLowerCase(s.charAt(endIdx));
      if (startChar != endChar) {
        return false;
      }
      startIdx++;
      endIdx--;
    }
    return true;
  }
}
