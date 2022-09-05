class Solution {
  public boolean isStrictlyPalindromic(int n) {
    for (int i = 2; i <= n - 2; i++) {
      if (!isPalindrome(convertToBase(n, i))) {
        return false;
      }
    }
    return true;
  }
  
  private String convertToBase(int n, int base) {
    StringBuilder sb = new StringBuilder();
    while (n > 0) {
      sb.append(n % base);
      n /= base;
    }
    return sb.reverse().toString();
  }
  
  private boolean isPalindrome(String s) {
    int start = 0;
    int end = s.length() - 1;
    while (start < end) {
      if (s.charAt(start) != s.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }
    return true;
  }
}
