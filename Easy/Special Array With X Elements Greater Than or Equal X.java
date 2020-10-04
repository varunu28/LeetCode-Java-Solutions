class Solution {
  public int specialArray(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    for (int i = n - 1; i >= 0; i--) {
      while (i > 0 && nums[i] == nums[i - 1]) {
        i--;
      }
      if (i > 0 && n - i > nums[i - 1] && n - i <= nums[i]) {
        return n - i;
      }
    }
    if(n == nums[0] || nums[0] > 0 && nums[0] - 1 == n) {
      return n;
    }
    return -1;
  }
}
