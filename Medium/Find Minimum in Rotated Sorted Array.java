class Solution {
  public int findMin(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    int left = 0;
    int right = nums.length - 1;
    // Sorted but not rotated
    if (nums[right] > nums[left]) {
      return nums[left];
    }
    while (left <= right) {
      int mid = (left + right) / 2;
      // mid + 1 is point of rotation
      if (nums[mid] > nums[mid + 1]) {
        return nums[mid + 1];
      }
      // mid is point of rotation
      if (nums[mid - 1] > nums[mid]) {
        return nums[mid];
      }
      if (nums[mid] > nums[0]) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return Integer.MAX_VALUE;
  }
}
