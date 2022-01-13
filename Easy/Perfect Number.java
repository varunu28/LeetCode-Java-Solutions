class Solution {
  public boolean checkPerfectNumber(int num) {
    if (num == 1) {
      return false;
    } 
    return getDivisorSum(num) == num;
  }

  private int getDivisorSum(int num) {
    int sum = 0;
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) {
        sum += i + num / i;
      }
    }
    return sum + 1;
  }
}
