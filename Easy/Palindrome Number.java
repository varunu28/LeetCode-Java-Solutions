class Solution {
  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }
    int reversedNum = 0;
    int xCopy = x;
    while (x > 0) {
      int rem = x % 10;
      reversedNum = reversedNum * 10 + rem;
      x /= 10;
    }
    return reversedNum == xCopy;
  }
}
