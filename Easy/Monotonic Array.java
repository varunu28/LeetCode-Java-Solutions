class Solution {
  public boolean isMonotonic(int[] nums) {
    if (nums.length < 2) {
      return true;
    }
    Boolean increasing = null;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1] && increasing == null) {
        continue;
      }
      increasing = increasing == null ? nums[i] > nums[i - 1] : increasing;
      if ((nums[i] > nums[i - 1] && !increasing) || (nums[i] < nums[i - 1] && increasing)) {
        return false;
      }
    }
    return true;
  }
}
