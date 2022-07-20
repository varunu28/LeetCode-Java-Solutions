class Solution {
  public int[] searchRange(int[] nums, int target) {
    return new int[]{binarySearchHelper(nums, target, -1), binarySearchHelper(nums, target, 1)};
  }
  
  private int binarySearchHelper(int[] nums, int target, int direction) {
    int idx = -1;
    int start = 0;
    int end = nums.length - 1;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (nums[mid] == target) {
        idx = idx == -1 ? mid : (direction == -1 ? Math.min(mid, idx) : Math.max(mid, idx));
        if (direction == -1) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      } else if (nums[mid] > target) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return idx;
  }
}
