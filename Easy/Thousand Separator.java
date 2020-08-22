class Solution {
  public String thousandSeparator(int n) {
    if (n == 0) {
      return "0";
    }
    StringBuilder sb = new StringBuilder();
    int count = 0;
    while (n > 0) {
      int rem = n % 10;
      sb.append(rem);
      count++;
      n /= 10;
      if (count == 3 && n > 0) {
        sb.append('.');
        count = 0;
      }
    }
    return sb.reverse().toString();
  }
}
