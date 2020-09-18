class Solution {
  public int search(int[] nums, int target) {
    return binarySearchImpl(nums, 0, nums.length - 1, target);
  }
  
  private int binarySearchImpl(int[] nums, int start, int end, int target) {
    while (start <= end) {
      int mid = (start + end) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      else if (nums[mid] > target) {
        end = mid - 1;
      }
      else {
        start = mid + 1;
      }
    }
    return -1;
  }
}
