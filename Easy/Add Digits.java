class Solution {
  public int addDigits(int num) {
    while (isDigitCountGreaterThanOne(num)) {
      num = getDigitSum(num);
    }
    return num;
  }
  
  private int getDigitSum(int num) {
    int sum = 0;
    while (num > 0) {
      sum += num % 10;
      num /= 10;
    }
    return sum;
  }
  
  private boolean isDigitCountGreaterThanOne(int num) {
    int count = 0;
    while (num > 0) {
      num /= 10;
      count++;
      if (count > 1) {
        return true;
      }
    }
    return false;
  }
}
