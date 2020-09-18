class Solution {
  public boolean isPerfectSquare(int num) {
    return binarySearchHelper((long)1, (long)num, num) == -1 ? false : true;
  }
  
  private int binarySearchHelper(long start, long end, int num) {
    while (start <= end) {
      long mid = (start + end) / 2;
      long square = (long) Math.pow(mid, 2);
      if (square == num) {
        return (int) mid;
      }
      else if (square > num) {
        end = mid - 1;
      }
      else {
        start = mid + 1;
      }
    }
    return -1;
  }
}
