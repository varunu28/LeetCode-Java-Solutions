class Solution {
  public String reverseOnlyLetters(String S) {
    int start = 0;
    int end = S.length() - 1;
    char[] chars = S.toCharArray();
    while (start <= end) {
      while (start <= end && !Character.isLetter(chars[start])) {
        start++;
      }
      while (end >= start && !Character.isLetter(chars[end])) {
        end--;
      }
      if (start <= end) {
        char temp = chars[start];
        chars[start] = chars[end];
        chars[end] = temp;
      }
      start++;
      end--;
    }
    return String.valueOf(chars);
  }
}
