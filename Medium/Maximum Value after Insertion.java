class Solution {
  public String maxValue(String n, int x) {
    if (n.charAt(0) == '-') {
      for (int i = 1; i < n.length(); i++) {
        if (Character.getNumericValue(n.charAt(i)) > x) {
          return "-" + n.substring(1, i) + x + n.substring(i);
        }
      }
    } else {
      for (int i = 0; i < n.length(); i++) {
        if (Character.getNumericValue(n.charAt(i)) < x) {
          return n.substring(0, i) + x + n.substring(i);
        }
      }
    }
    return n + x;
  }
}
