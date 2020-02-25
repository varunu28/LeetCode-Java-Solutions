class Solution {
  public String reverseWords(String s) {
    int idx = 0;
    int n = s.length();
    StringBuilder sb = new StringBuilder();
    int start = 0;
    while (idx < n) {
      while (idx < n && s.charAt(idx) != ' ') {
        idx++;
      }
      int curr = idx - 1;
      while (curr >= start) {
        sb.append(s.charAt(curr--));
      }
      if (idx != n) {
        sb.append(" ");
      }
      idx++;
      start = idx;
    }
    return sb.toString();
  }
}
