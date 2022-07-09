class Solution {
  public boolean isPerfectSquare(int num) {
    if (num == 1) {
      return true;
    }
    long start = 2;
    long end = num / 2;
    while (start <= end) {
      long mid = start + (end - start) / 2;
      long currSquare = mid * mid;
      if (currSquare == num) {
        return true;
      }
      if (currSquare > num) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return false;
  }
}
