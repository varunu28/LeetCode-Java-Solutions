class Solution {
  public boolean checkPossibility(int[] nums) {
    boolean mismatch = false;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] > nums[i]) {
        if (mismatch) {
          return false;
        }
        if (i < 2 || nums[i - 2] <= nums[i]) {
          nums[i - 1] = nums[i];
        } else {
          nums[i] = nums[i - 1];
        }
        mismatch = true;
      }
    }
    return true;
  }
}
