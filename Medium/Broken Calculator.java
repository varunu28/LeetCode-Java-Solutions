class Solution {
  public int brokenCalc(int startValue, int target) {
    int numOfSteps = 0;
    while (target > startValue) {
      numOfSteps++;
      if (target % 2 == 1) {
        target++;
      } else {
        target /= 2;
      }
    }
    return numOfSteps + startValue - target;
  }
}
