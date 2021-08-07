class Solution {
  public String makeFancyString(String s) {
    int idx = 0;
    StringBuilder sb = new StringBuilder();
    while (idx < s.length()) {
      char c = s.charAt(idx);
      int count = 0;
      while (idx < s.length() && s.charAt(idx) == c) {
        idx++;
        count++;
        if (count <= 2) {
          sb.append(c);
        }
      }
    }
    return sb.toString();
  }
}
