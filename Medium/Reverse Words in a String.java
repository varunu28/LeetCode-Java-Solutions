class Solution {
  public String reverseWords(String s) {
    StringBuilder sb = trimSpace(s);
    reverse(sb, 0, sb.length() - 1);
    int start = 0;
    int end = 0;
    int n = sb.length();
    while (start < n) {
      while (end < n && sb.charAt(end) != ' ') {
        end++;
      }
      reverse(sb, start, end - 1);
      start = end + 1;
      end++;
    }
    return sb.toString();
  }
  
  private void reverse(StringBuilder sb, int start, int end) {
    while (start <= end) {
      char temp = sb.charAt(start);
      sb.setCharAt(start++, sb.charAt(end));
      sb.setCharAt(end--, temp);
    }
  }
  
  private StringBuilder trimSpace(String s) {
    StringBuilder sb = new StringBuilder();
    int start = 0;
    int end = s.length() - 1;
    while (start <= end && s.charAt(start) == ' ') {
      start++;
    }
    while (end >= start && s.charAt(end) == ' ') {
      end--;
    }
    while (start <= end) {
      if (s.charAt(start) != ' ') {
        sb.append(s.charAt(start++));
      } else {
        if (sb.charAt(sb.length() - 1) != ' ') {
          sb.append(s.charAt(start));
        }
        start++;
      }
    }
    return sb;
  }
}
