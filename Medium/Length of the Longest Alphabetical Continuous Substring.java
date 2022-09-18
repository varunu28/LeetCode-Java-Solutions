class Solution {
  public int longestContinuousSubstring(String s) {
    int idx = 0;
    int maxLength = 0;
    while (idx < s.length()) {
      int currIdx = idx++;
      while (idx < s.length() && s.charAt(idx) - s.charAt(idx - 1) == 1) {
        idx++;
      }
      maxLength = Math.max(maxLength, idx - currIdx);
    }
    return maxLength;
  }
}
