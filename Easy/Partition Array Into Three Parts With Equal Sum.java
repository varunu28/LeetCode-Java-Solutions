class Solution {
  public boolean canThreePartsEqualSum(int[] A) {
    int totalSum = 0;
    for (int num : A) {
      totalSum += num;
    }
    if (totalSum % 3 != 0) {
      return false;
    }
    totalSum = totalSum / 3;
    int currSum = 0;
    int segmentCount = 0;
    for (int num : A) {
      currSum += num;
      if (currSum == totalSum) {
        segmentCount++;
        currSum = 0;
      }
    }
    return segmentCount >= 3;
  }
}
