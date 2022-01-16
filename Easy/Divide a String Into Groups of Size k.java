class Solution {
  public String[] divideString(String s, int k, char fill) {
    int n = s.length() % k  == 0 ? s.length() / k : s.length() / k + 1;
    String[] result = new String[n];
    int idx = 0;
    for (int i = 0; i < n; i++) {
      String split = s.substring(idx, Math.min(idx + k, s.length()));
      result[i] = formString(split, k, fill);
      idx += k;
    }
    return result;
  }

  private String formString(String s, int k, char fill) {
    if (s.length() != k) {
      return s + String.join("", Collections.nCopies(k - s.length(), String.valueOf(fill)));
    }
    return s;
  }
}
