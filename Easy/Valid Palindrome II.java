class Solution {
  public boolean validPalindrome(String s) {
    int[] firstPalindromeCheck = isPalindromHelper(s);
    if (firstPalindromeCheck[0] == -1) {
      return true;
    }
    int[] skipLeft = isPalindromHelper(s.substring(firstPalindromeCheck[0] + 1, firstPalindromeCheck[1] + 1));
    int[] skipRight = isPalindromHelper(s.substring(firstPalindromeCheck[0], check[1]));
    return skipLeft[0] == -1 || skipRight[0] == -1;
  }

  private int[] isPalindromHelper(String s) {
    int startIdx = 0;
    int endIdx = s.length() - 1;
    while (startIdx < endIdx && s.charAt(startIdx) == s.charAt(endIdx)) {
      startIdx++;
      endIdx--;
    }
    return startIdx >= endIdx ? new int[]{-1} : new int[]{startIdx, endIdx};
  }
}
