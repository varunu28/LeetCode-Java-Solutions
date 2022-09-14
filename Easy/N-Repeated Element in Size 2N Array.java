class Solution {
  public int repeatedNTimes(int[] nums) {
    for (int i = 1; i <= 3; i++) {
      for (int j = 0; j < nums.length - i; j++) {
        if (nums[j] == nums[j + i]) {
          return nums[j];
        }
      }
    }
    return -1;
  }
}
