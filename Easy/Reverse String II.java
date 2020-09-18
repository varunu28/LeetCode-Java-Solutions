class Solution {
  public String reverseStr(String s, int k) {
    StringBuilder sb = new StringBuilder();
    boolean current = true;
    int idx = 0;
    int n = s.length();
    while (idx < n) {
      int endIdx = Math.min(idx + k - 1, n - 1);
      if (current) {
        int end = idx;
        int start = endIdx;
        for (int i = start; i >= end; i--) {
          sb.append(s.charAt(i));
        }
        idx = endIdx + 1;
      }
      else {
        while (idx <= endIdx) {
          sb.append(s.charAt(idx++));
        }
      }
      current = !current;
      System.out.println(idx);
    }
    return sb.toString();
  }
}
