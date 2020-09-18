class Solution {
  public int arrangeCoins(int n) {
    int copy = n;
    int count = 0;
    for (int i = 1; i <= copy && n > 0; i++) {
      n -= i;
      if (n < 0) {
        break;
      }
      count++;
    }
    return count;
  }
}
