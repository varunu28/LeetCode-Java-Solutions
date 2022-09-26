class Solution {
  public int minStartValue(int[] nums) {
    int startingValue = 1;
    int currSum = 1;
    for (int num : nums) {
      if (currSum + num < 1) {
        int diff = 1 - (currSum + num);
        startingValue += diff;
        currSum += diff;
      }
      currSum += num;
    }
    return startingValue;
  }
}
