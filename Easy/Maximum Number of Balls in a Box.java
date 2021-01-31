class Solution {
  public int countBalls(int lowLimit, int highLimit) {
    Map<Integer, Integer> map = new HashMap<>();
    int maxCount = 0;
    for (int num = lowLimit; num <= highLimit; num++) {
      int digitSum = getDigitSum(num);
      map.put(digitSum, map.getOrDefault(digitSum, 0) + 1);
      maxCount = Math.max(maxCount, map.get(digitSum));
    }
    return maxCount;
  }
  
  private int getDigitSum(int num) {
    int sum = 0;
    while (num > 0) {
      sum += num % 10;
      num /= 10;
    }
    return sum;
  }
}
