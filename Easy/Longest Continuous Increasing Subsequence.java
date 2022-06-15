class Solution {
  public int findLengthOfLCIS(int[] nums) {
    int maxLength = 1;
    int idx = 0;
    while (idx < nums.length) {
      int count = 1;
      while (idx < nums.length && idx + 1 < nums.length && nums[idx] < nums[idx + 1]) {
        idx++;
        count++;
      }
      maxLength = Math.max(maxLength, count);
      idx++;
    }
    return maxLength;
  }
}
