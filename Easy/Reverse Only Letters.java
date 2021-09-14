class Solution {
  public String reverseOnlyLetters(String s) {
    int start = 0;
    int end = s.length() - 1;
    char[] letters = s.toCharArray();
    while (start <= end) {
      while (start <= end && !Character.isLetter(s.charAt(start))) {
        start++;
      }
      while (end >= start && !Character.isLetter(s.charAt(end))) {
        end--;
      }
      if (start <= end) {
        char temp = letters[start];
        letters[start++] = letters[end];
        letters[end--] = temp;
      }
    }
    return String.valueOf(letters);
  }
}
