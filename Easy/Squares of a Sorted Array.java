class Solution {
  public int[] sortedSquares(int[] nums) {
    int firstNegativeIdx = nums[0] < 0 ? 0 : nums.length;
    int lastPositiveIdx = nums[nums.length - 1] >= 0 ? nums.length - 1 : -1;
    int[] result = new int[nums.length];
    int idx = result.length - 1;
    while (idx >= 0) {
      if (firstNegativeIdx < nums.length && lastPositiveIdx >= 0) {
        if (Math.abs(nums[firstNegativeIdx]) > nums[lastPositiveIdx]) {
          result[idx--] = nums[firstNegativeIdx] * nums[firstNegativeIdx];
          firstNegativeIdx++;
          if (firstNegativeIdx < nums.length && nums[firstNegativeIdx] >= 0) {
            firstNegativeIdx = nums.length;
          }
        } else {
          result[idx--] = nums[lastPositiveIdx] * nums[lastPositiveIdx];
          lastPositiveIdx--;
          if (lastPositiveIdx >= 0 && nums[lastPositiveIdx] < 0) {
            lastPositiveIdx = -1;
          }
        }
      } else if (firstNegativeIdx < nums.length && lastPositiveIdx < 0) {
          result[idx--] = nums[firstNegativeIdx] * nums[firstNegativeIdx];
          firstNegativeIdx++;
      } else {
          result[idx--] = nums[lastPositiveIdx] * nums[lastPositiveIdx];
          lastPositiveIdx--;
      }
    }
    return result;
  }
}
