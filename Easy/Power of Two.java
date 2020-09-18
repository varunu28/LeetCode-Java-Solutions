class Solution {
  public boolean isPowerOfTwo(int n) {
    if (n % 2 != 0 && n != 1) {
      return false;
    }
    int start = 0;
    int end = n / 2;
    while (start <= end) {
      int mid = (start + end) / 2;
      int pow = (int) (Math.pow(2, mid));
      if (n == pow) {
        return true;
      }
      else if (n > pow) {
        start = mid + 1;
      }
      else {
        end = mid - 1;
      }
    }
    return false;
  }
}
