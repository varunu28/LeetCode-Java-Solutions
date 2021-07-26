class Solution {
  public int getLucky(String s, int k) {
    StringBuilder sb = new StringBuilder();
    for (char c : s.toCharArray()) {
      sb.append(c - 'a' + 1);
    }
    String num = sb.toString();
    while (k-- > 0) {
      int sum = 0;
      for (char c : num.toCharArray()) {
        sum += Character.getNumericValue(c);
      }
      num = String.valueOf(sum);
    }
    return Integer.parseInt(num);
  }
}
