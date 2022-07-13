class Solution {
  public boolean validPalindrome(String s) {
    return validPalindromeHelper(s, false);
  }
  
  private boolean validPalindromeHelper(String s, boolean deleted) {
    int startIdx = 0;
    int endIdx = s.length() - 1;
    while (startIdx < endIdx) {
      if (s.charAt(startIdx) != s.charAt(endIdx)) {
        if (deleted) {
          return false;
        }
        return validPalindromeHelper(s.substring(0, startIdx) + s.substring(startIdx + 1), true) ||
               validPalindromeHelper(s.substring(0, endIdx) + s.substring(endIdx + 1), true);
      }
      startIdx++;
      endIdx--;
    }
    return true;
  }
}
