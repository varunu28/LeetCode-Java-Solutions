class Solution {
  public String toLowerCase(String str) {
    StringBuilder sb = new StringBuilder();
    for (char c : str.toCharArray()) {
      int ascii = (int) c;
      if (c >= 65 && c <= 90) {
        sb.append((char) (c - 65 + 97));
      }
      else {
        sb.append(c);
      }
    }
    return sb.toString();
  }
}
