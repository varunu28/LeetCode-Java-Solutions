class Solution {
  public int minMoves(int target, int maxDoubles) {
    int numOfSteps = 0;
    while (target > 0 && maxDoubles > 0) {
      if (target % 2 == 0) {
        maxDoubles--;
        target /= 2;
      } else {
        target--;
      }
      numOfSteps++;
    }
    return numOfSteps + target - 1;
  }
}
