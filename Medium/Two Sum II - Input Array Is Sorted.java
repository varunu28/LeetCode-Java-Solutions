class Solution {
  public int[] twoSum(int[] numbers, int target) {
    int leftIdx = 0;
    int rightIdx = numbers.length - 1;
    while (leftIdx < rightIdx) {
      int currSum = numbers[leftIdx] + numbers[rightIdx];
      if (currSum == target) {
        return new int[]{leftIdx + 1, rightIdx + 1};
      } else if (currSum > target) {
        rightIdx--;
      } else {
        leftIdx++;
      }
    }
    return new int[]{0};
  }
}
