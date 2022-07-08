class Solution {
  public int[] sortedSquares(int[] nums) {
    int negativeIdx = 0;
    int positiveIdx = nums.length - 1;
    int[] result = new int[nums.length];
    int resultIdx = nums.length - 1;
    while(resultIdx >= 0) {
      if (nums[negativeIdx] < 0 && nums[positiveIdx] >= 0) {
        if (Math.abs(nums[negativeIdx]) > nums[positiveIdx]) {
          result[resultIdx--] = nums[negativeIdx] * nums[negativeIdx];
          negativeIdx++;
        } else {
          result[resultIdx--] = nums[positiveIdx] * nums[positiveIdx];
          positiveIdx--;
        }
      } else if (nums[negativeIdx] < 0 && nums[positiveIdx] < 0) {
        result[resultIdx--] = nums[negativeIdx] * nums[negativeIdx];
        negativeIdx++;
      } else {
        result[resultIdx--] = nums[positiveIdx] * nums[positiveIdx];
        positiveIdx--;  
      }
    }
    return result;
  }
}
