class Solution {
  public int minStartValue(int[] nums) {
    int startValue = 1;
    int currSum = startValue;
    for (int num : nums) {
      currSum += num;
      if (currSum < 1) {
        startValue += 1 - currSum;
        currSum += 1 - currSum;
      }
    }
    return startValue;
  }
}
