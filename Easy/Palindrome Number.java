class Solution {
  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }
    return x - reverse(x) == 0;
  }
  
  private int reverse(int n) {
    int newNum = 0;
    while (n > 0) {
      newNum = newNum * 10 + n % 10;
      n /= 10;
    }
    return newNum;
  }
}
