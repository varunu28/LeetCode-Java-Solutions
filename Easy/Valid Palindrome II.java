class Solution {
  public boolean validPalindrome(String s) {
    int start = 0;
    int end = s.length() - 1;
    while (start < end && s.charAt(start) == s.charAt(end)) {
      start++;
      end--;
    }
    if (start >= end) {
      return true;
    }
    if (isPalindrome(s.substring(start + 1, end + 1)) || isPalindrome(s.substring(start, end))) {
      return true;
    }
    return false;
  }
  
  private boolean isPalindrome(String s) {
    int start = 0;
    int end = s.length() - 1;
    while (start < end && s.charAt(start) == s.charAt(end)) {
      start++;
      end--;
    }
    return start >= end;
  }
}
