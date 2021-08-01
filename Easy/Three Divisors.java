class Solution {
  public boolean isThree(int n) {
    int numOfDivisors = 0;
    for (int i = 1; i <= n; i++) {
      if (n % i == 0) {
        numOfDivisors++;
      }
      if (numOfDivisors > 3) {
        return false;
      }
    }
    return numOfDivisors == 3;
  }
}
