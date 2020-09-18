class Solution {
  public String freqAlphabets(String s) {
    StringBuilder sb = new StringBuilder();
    int idx = 0;
    int n = s.length();
    while (idx < n) {
      char c = s.charAt(idx);
      int asciiAdd = -1;
      if (idx + 2 < n && s.charAt(idx + 2) == '#') {
        asciiAdd = Integer.parseInt(s.substring(idx, idx + 2));
        idx += 3;
      }
      else {
        asciiAdd = Integer.parseInt(s.substring(idx, idx + 1));
        idx++;
      }
      sb.append((char) (96 + asciiAdd));
    }
    return sb.toString();
  }
}
