class Solution {
  public int maxPower(String s) {
    int maximumRepeatingCount = 0;
    for (int idx = 0; idx < s.length();) {
      char currentChar = s.charAt(idx);
      int currIdx = idx;
      while (idx < s.length() && s.charAt(idx) == currentChar) {
        idx++;
      }
      maximumRepeatingCount = Math.max(maximumRepeatingCount, idx - currIdx);
    }
    return maximumRepeatingCount;
  }
}
