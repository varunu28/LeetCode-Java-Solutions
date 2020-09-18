class Solution {
  public int[] searchRange(int[] nums, int target) {
    return new int[]{binarySearchHelper(nums, target, -1), binarySearchHelper(nums, target, 1)};
  } 
  
  private int binarySearchHelper(int[] nums, int target, int dir) {
    int start = 0;
    int end = nums.length - 1;
    int idx = -1;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (nums[mid] == target) {
        idx = mid;
        if (dir == -1) {
          end = mid - 1;
        }
        else {
          start = mid + 1;
        }
      }
      else if (nums[mid] < target) {
        start = mid + 1;
      }
      else {
        end = mid - 1;
      }
    }
    return idx;
  }
}
