class Solution {
  public boolean isHappy(int n) {
    int slow = n;
    int fast = getSquareDigitSum(n);
    while (fast != 1 && slow != fast) {
      slow = getSquareDigitSum(slow);
      fast = getSquareDigitSum(getSquareDigitSum(fast));
    }
    return fast == 1;
  }
  
  private int getSquareDigitSum(int n) {
    int squareDigitSum = 0;
    while (n > 0) {
      int digit = n % 10;
      squareDigitSum += digit * digit;
      n /= 10;
    }
    return squareDigitSum;
  }
}
