class Solution {
  public int maximumTop(int[] nums, int k) {
    if (nums.length == 1) {
      return k % 2 == 1 ? -1 : nums[0];
    }
    int maxTop = -1;
    if (k < nums.length) {
      maxTop = nums[k];
    } else if (k > nums.length) {
      k = nums.length + 1;
    }
    for (int i = 0; i < k - 1; i++) {
      maxTop = Math.max(maxTop, nums[i]);
    }
    return maxTop;
  }
}
