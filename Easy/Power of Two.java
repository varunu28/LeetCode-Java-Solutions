class Solution {
  public boolean isPowerOfTwo(int n) {
    if (n > 1 && n % 2 != 0) {
      return false;
    }
    int start = 0;
    int end = n / 2;
    while (start <= end) {
      int mid = (start + end) / 2;
      int pow = (int) Math.pow(2, mid);
      if (pow == n) {
        return true;
      } else if (pow > n) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return false;
  }
}
