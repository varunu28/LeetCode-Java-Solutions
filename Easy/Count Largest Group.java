class Solution {
  public int countLargestGroup(int n) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 1; i <= n; i++) {
      int digitSum = getDigitSum(i);
      map.put(digitSum, map.getOrDefault(digitSum, 0) + 1);
    }
    int maxCount = 0;
    int size = 0;
    for (Integer key : map.keySet()) {
      if (maxCount < map.get(key)) {
        maxCount = map.get(key);
        size = 1;
      }
      else if (maxCount == map.get(key)) {
        size++;
      }
    }
    return size;
  }
  
  private int getDigitSum(int n) {
    int sum = 0;
    while (n > 0) {
      sum += n % 10;
      n /= 10;
    }
    return sum;
  }
}
