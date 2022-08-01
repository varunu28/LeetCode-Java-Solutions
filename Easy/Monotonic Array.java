class Solution {
  public boolean isMonotonic(int[] nums) {
    int idx = 0;
    int sign = 0;
    while (idx < nums.length - 1 && sign == 0) {
      if (nums[idx] < nums[idx + 1]) {
        sign = 1;
      } else if (nums[idx] > nums[idx + 1]) {
        sign = -1;
      }
      idx++;
    }
    while (idx < nums.length - 1) {
      if ((sign == 1 && nums[idx] > nums[idx + 1]) || (sign == -1 && nums[idx] < nums[idx + 1])) {
        return false;
      }
      idx++;
    }
    return true;
  }
}
