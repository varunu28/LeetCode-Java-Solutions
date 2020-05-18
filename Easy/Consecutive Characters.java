class Solution {
  public int maxPower(String s) {
    int count = 0;
    int idx = 0;
    int n = s.length();
    while (idx < n) {
      char c = s.charAt(idx);
      int tempCount = 0;
      while (idx < n && s.charAt(idx) == c) {
        idx++;
        tempCount++;
      }
      count = Math.max(count, tempCount);
    }
    return count;
  }
}
