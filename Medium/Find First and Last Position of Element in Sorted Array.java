class Solution {
  public int[] searchRange(int[] nums, int target) {
    return new int[]{binarySearchForMinIdx(nums, target), binarySearchForMaxIdx(nums, target)};
  }
  
  private int binarySearchForMinIdx(int[] nums, int target) {
    int leftIdx = 0;
    int rightIdx = nums.length - 1;
    int idx = -1;
    while (leftIdx <= rightIdx) {
      int mid = (leftIdx + rightIdx) / 2;
      if (nums[mid] == target) {
        idx = mid;
        rightIdx = mid - 1;
      } else if (nums[mid] > target) {
        rightIdx = mid - 1;
      } else {
        leftIdx = mid + 1;
      }
    }
    return idx;
  }
  
  private int binarySearchForMaxIdx(int[] nums, int target) {
    int leftIdx = 0;
    int rightIdx = nums.length - 1;
    int idx = -1;
    while (leftIdx <= rightIdx) {
      int mid = (leftIdx + rightIdx) / 2;
      if (nums[mid] == target) {
        idx = mid;
        leftIdx = mid + 1;
      } else if (nums[mid] > target) {
        rightIdx = mid - 1;
      } else {
        leftIdx = mid + 1;
      }
    }
    return idx;
  }
}
