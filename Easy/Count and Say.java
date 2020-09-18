class Solution {
  public String countAndSay(int n) {
    return rec(n, "1");
  }
  
  private String rec(int n, String s) {
    if (n == 1) {
      return s;
    }
    StringBuilder sb = new StringBuilder();
    int idx = 0;
    while (idx < s.length()) {
      char c = s.charAt(idx);
      int count = 0;
      while (idx < s.length() && s.charAt(idx) == c) {
        idx++;
        count++;
      }
      sb.append(count).append(c);
    }
    return rec(n - 1, sb.toString());
  }
}
