class Solution {
  public boolean hasAlternatingBits(int n) {
    Integer prev = null;
    while (n > 0) {
      int rem = n % 2;
      n /= 2;
      if (prev == null || prev != rem) {
        prev = rem;
      } else {
        return false;
      }
    }
    return true;
  }
}
