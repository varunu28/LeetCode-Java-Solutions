class Solution {
  public boolean isPowerOfFour(int num) {
    long start = 0;
    long end = num / 4;
    while (start <= end) {
      long mid = (start + end) / 2;
      long pow = (long) Math.pow(4, mid);
      if (pow == (long) num) {
        return true;
      }
      else if (pow > (long) num) {
        end = mid - 1;
      }
      else {
        start = mid + 1;
      }
    }
    return false;
  }
}
