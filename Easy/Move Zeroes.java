class Solution {
  public void moveZeroes(int[] nums) {
    int startIdx = 0;
    int endIdx = 0;
    while (endIdx < nums.length) {
      if (nums[endIdx] != 0) {
        nums[startIdx++] = nums[endIdx];
      }
      endIdx++;
    }
    while (startIdx < nums.length) {
      nums[startIdx++] = 0;
    }
  }
}
