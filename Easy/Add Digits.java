class Solution {
  public int addDigits(int num) {
    while (String.valueOf(num).length() > 1) {
      num = getDigitSum(num);
    }
    return num;
  }
  
  private int getDigitSum(int n) {
    int newNum = 0;
    while (n > 0) {
      newNum += n % 10;
      n /= 10;
    }
    return newNum;
  }
}
