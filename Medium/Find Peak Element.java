class Solution {
  public int findPeakElement(int[] nums) {
    int[] index = {-1};
    helper(nums, 0, nums.length - 1, index);
    return index[0];
  }
  
  private void helper(int[] nums, int start, int end, int[] index) {
    if (start <= end && index[0] == -1) {
      int mid = (start + end) / 2;
      boolean found = (
          (mid + 1 < nums.length ? nums[mid] > nums[mid + 1] : true) &&
          (mid - 1 >= 0 ? nums[mid] > nums[mid - 1] : true)
        );
      if (found) {
        index[0] = mid;
        return;
      }
      else {
        helper(nums, start, mid - 1, index);
        helper(nums, mid + 1, end, index);
      }
    }
  }
}
