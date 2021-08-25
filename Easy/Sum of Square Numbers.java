class Solution {
  public boolean judgeSquareSum(int c) {
    int left = 0;
    int right = (int) Math.sqrt(c);
    while (left <= right) {
      int currSquareSum = left * left + right * right;
      if (currSquareSum < c) {
        left++;
      } else if (currSquareSum > c) {
        right--;
      } else {
        return true;
      }
    }
    return false;
  }
}
