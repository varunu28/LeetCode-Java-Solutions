class Solution {
  public String removeOccurrences(String s, String part) {
    while (true) {
      int idx = s.indexOf(part);
      if (idx == -1) {
        break;
      }
      s = s.substring(0, idx) + s.substring(idx + part.length());
    }
    return s;
  }
}
