class Solution {
  public int countSubstrings(String s) {
    int[] palindromeCount = {0};
    for (int i = 0; i < s.length(); i++) {
      checkPalindrome(s, i, i, palindromeCount);
      checkPalindrome(s, i, i + 1, palindromeCount);
    }    
    return palindromeCount[0];
  }
  
  private void checkPalindrome(String s, int leftIdx, int rightIdx, int[] palindromeCount) {
    while (leftIdx >= 0 && rightIdx < s.length() && s.charAt(leftIdx) == s.charAt(rightIdx)) {
      palindromeCount[0]++;
      leftIdx--;
      rightIdx++;
    }
  }
}
