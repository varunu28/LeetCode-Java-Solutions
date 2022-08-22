class Solution {
  public boolean isPowerOfFour(int n) {
    long left = 0;
    long right = n / 2 + 1;
    while (left <= right) {
      long mid = (left + right) / 2;
      long pow = (long) (Math.pow(4, mid));
      if (pow == ((long) n)) {
        return true;
      }
      if (pow > ((long) n)) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return false;
  }
}
