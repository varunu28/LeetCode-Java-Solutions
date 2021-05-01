class Solution {
  public String replaceDigits(String s) {
    StringBuilder sb = new StringBuilder();
    int n = s.length();
    for (int i = 1; i < n; i += 2) {
      char c = s.charAt(i - 1);
      sb.append(c).append((char) (((int) c) + Character.getNumericValue(s.charAt(i))));
    }
    return n % 2 != 0 ? sb.append(s.charAt(n - 1)).toString() : sb.toString();
  }
}
