class Solution {
  public boolean checkOnesSegment(String s) {
    boolean foundContiguousSegment = false;
    int idx = 0;
    int n = s.length();
    while (idx < n) {
      int count = 0;
      while (idx < n && s.charAt(idx) == '1') {
        count++;
        idx++;
      }
      if (count >= 1) {
        if (foundContiguousSegment) {
          return false;
        }
        foundContiguousSegment = true;
      } else {
        idx++;
      }
    }
    return foundContiguousSegment;
  }
}
