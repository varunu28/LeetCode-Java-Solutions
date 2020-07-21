class Solution {
  public boolean isPalindrome(String s) {
    int start = 0;
    int end = s.length() - 1;
    while (start < end) {
      if (Character.isLetterOrDigit(s.charAt(start)) && Character.isLetterOrDigit(s.charAt(end))) {
        char c1 = Character.isLetter(s.charAt(start)) ? Character.toLowerCase(s.charAt(start)) : s.charAt(start);
        char c2 = Character.isLetter(s.charAt(end)) ? Character.toLowerCase(s.charAt(end)) : s.charAt(end);
        if (c1 != c2) {
          return false;
        }
        start++;
        end--;
      }
      else {
        if (!Character.isLetterOrDigit(s.charAt(start))) {
          start++;
        }
        if (!Character.isLetterOrDigit(s.charAt(end))) {
          end--;
        }
      }
    }
    return true;
  }
}
