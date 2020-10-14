class Solution {
  public int rob(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
  }
  
  private int robHelper(int[] nums, int lower, int higher) {
    int include = 0;
    int exclude = 0;
    for (int j = lower; j <= higher; j++) {
      int includeIdx = include;
      int excludeIdx = exclude;
      include = excludeIdx + nums[j];
      exclude = Math.max(excludeIdx, includeIdx);
    }
    return Math.max(include, exclude);
  }
}
