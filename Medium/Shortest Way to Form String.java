class Solution {
  public int shortestWay(String source, String target) {
    int count = 1;
    int idx = 0;
    int n = target.length();
    int sourceIdx = 0;
    boolean match = false;
    while (idx < n) {
      if (source.charAt(sourceIdx) == target.charAt(idx)) {
        idx++;
        sourceIdx++;
        match = true;
      }
      else {
        sourceIdx++;
      }
      if (sourceIdx == source.length() && idx != n) {
        if (!match) {
          return -1;
        }
        count++;
        sourceIdx = 0;
        match = false;
      }
    }
    return count;
  }
}
