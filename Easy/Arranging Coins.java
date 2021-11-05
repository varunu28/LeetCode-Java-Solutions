class Solution {
  public int arrangeCoins(int n) {
    long left = 1;
    long right = n;
    while (left <= right) {
      long mid = (left + right) / 2;
      long sum = mid * (mid + 1) / 2;
      if (sum == n) {
        return (int) mid;
      } else if (sum > n) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return (int) right;
  }
}
