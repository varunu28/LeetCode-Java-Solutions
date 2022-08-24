class Solution {
  public boolean isPowerOfThree(int n) {
    int left = 0;
    int right = n / 3;
    while (left <= right) { 
      int mid = (left + right) / 2;
      double powValue = Math.pow(3, mid);
      if (powValue == n) {
        return true;
      }
      if (powValue > n) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return false;
  }
}
