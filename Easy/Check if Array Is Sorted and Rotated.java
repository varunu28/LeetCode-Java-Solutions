class Solution {
  public boolean check(int[] nums) {
    boolean rotationFound = false;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] > nums[i + 1]) {
        if (rotationFound) {
          return false;
        }
        rotationFound = true;
      }
    }
    if (rotationFound && nums[nums.length - 1] > nums[0]) {
      return false;
    }
    return true;
  }
}
