class Solution {
  public int compress(char[] chars) {
    int idx = 0;
    int startIdx = 0;
    while (idx < chars.length) {
      char c = chars[idx];
      int count = 0;
      while (idx < chars.length && chars[idx] == c) {
        idx++;
        count++;
      }
      chars[startIdx++] = c;
      if (count > 1) {
        String countString = String.valueOf(count);
        for (char cs : countString.toCharArray()) {
          chars[startIdx++] = cs;
        }
      }
    }
    return startIdx;
  }
}
