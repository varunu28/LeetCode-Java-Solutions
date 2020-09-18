class Solution {
  public boolean isHappy(int n) {
    Set<Integer> set = new HashSet<>();
    set.add(n);
    while (true) {
      int sumOfDigitSquare = getSumOfDigitSquare(n);
      if (sumOfDigitSquare == 1) {
        return true;
      }
      if (set.contains(sumOfDigitSquare)) {
        break;
      }
      set.add(sumOfDigitSquare);
      n = sumOfDigitSquare;
    }
    return false;
  }
  
  private int getSumOfDigitSquare(int n) {
    int sum = 0;
    while (n > 0) {
      sum += (int) Math.pow(n % 10, 2);
      n /= 10;
    }
    return sum;
  }
}
