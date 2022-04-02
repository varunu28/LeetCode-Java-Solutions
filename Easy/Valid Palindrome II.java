class Solution {
  public boolean validPalindrome(String s) {
    int startIdx = 0;
    int endIdx = s.length() - 1;
    while (startIdx < endIdx) {
      if (s.charAt(startIdx) != s.charAt(endIdx)) {
        return isPalindromeWithDeletion(s, startIdx + 1, endIdx) || 
          isPalindromeWithDeletion(s, startIdx, endIdx - 1);
      }
      startIdx++;
      endIdx--;
    }
    return true;
  } 
  
  private boolean isPalindromeWithDeletion(String s, int startIdx, int endIdx) {
    while (startIdx < endIdx) {
      if (s.charAt(startIdx) != s.charAt(endIdx)) {
        return false;
      }
      startIdx++;
      endIdx--;
    }
    return true;
  }
}
