class Solution {
  public int singleNonDuplicate(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    return binarySearchHelper(nums, 0, nums.length - 1);
  }
  
  private int binarySearchHelper(int[] nums, int start, int end) {
    if (start > end) {
      return Integer.MIN_VALUE;
    }
    int mid = (start + end) / 2;
    if (mid == 0 && mid + 1 < nums.length && nums[mid] != nums[mid + 1]) {
      return nums[mid];
    }
    if (mid == nums.length - 1 && mid - 1 >= 0 && nums[mid] != nums[mid - 1]) {
      return nums[mid];
    }
    if (mid + 1 < nums.length && nums[mid] != nums[mid + 1] && mid - 1 >= 0 && nums[mid] != nums[mid - 1]) {
      return nums[mid];
    }
    return Math.max(binarySearchHelper(nums, start, mid - 1), binarySearchHelper(nums, mid + 1, end));
  }
}
