class Solution {
  public int countEven(int num) {
    return (int) IntStream.range(1, num + 1).boxed().filter(this::isSumOfDigitsEven).count();
  }
  
  private boolean isSumOfDigitsEven(int num) {
    int sum = 0;
    while (num > 0) {
      sum += num % 10;
      num /= 10;
    }
    return sum % 2 == 0;
  }
}
