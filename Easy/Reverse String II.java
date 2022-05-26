class Solution {
  public String reverseStr(String s, int k) {
    boolean reverse = true;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i += k) {
      String substring = s.substring(i, Math.min(i + k, s.length()));
      if (reverse) {
        sb.append(new StringBuilder().append(substring).reverse().toString());
      } else {
        sb.append(substring);
      }
      reverse = !reverse;
    }
    return sb.toString();
  }
}
