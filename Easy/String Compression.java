class Solution {
  public int compress(char[] chars) {
    int start = 0;
    int end = 0;
    int n = chars.length;
    while (end < n) {
      char c = chars[end];
      int count = 0;
      while (end < n && chars[end] == c) {
        end++;
        count++;
      }
      chars[start++] = c;
      if (count > 1) {
        String countStr = String.valueOf(count);
        for (char countC : countStr.toCharArray()) {
          chars[start++] = countC;
        }
      }
    }
    return start;
  }
}
