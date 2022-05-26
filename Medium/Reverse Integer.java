class Solution {
  public int reverse(int x) {
    int reverse = 0;
    while (x != 0) {
      int rem = x % 10;
      x /= 10;
      if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && rem > 7)) {
        return 0;
      }
      if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && rem < -8)) {
        return 0;
      }
      reverse = reverse * 10 + rem;
    }
    return reverse;
  }
}
