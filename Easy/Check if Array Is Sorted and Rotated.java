class Solution {
  public boolean check(int[] nums) {
    boolean rotated = false;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] > nums[i + 1]) {
        if (rotated) {
          return false;
        }
        rotated = true;
      }
    }
    return !rotated || nums[nums.length - 1] <= nums[0];
  }
}
