class Solution {
  public String truncateSentence(String s, int k) {
    int idx = 0;
    while (idx < s.length() && k > 0) {
      if (s.charAt(idx) == ' ') {
        k--;
      }
      idx++;
    }
    return s.substring(0, (idx == s.length() ? idx : idx - 1));
  }
}
