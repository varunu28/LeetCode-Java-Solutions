class Solution {
  public boolean search(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
    int mid = -1;
    while (start <= end) {
      mid = (start + end) / 2;
      if (nums[mid] == target) {
        return true;
      }
      // Either right side is sorted or left side is unsorted
      if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
        if (target > nums[mid] && target <= nums[end]) {
          start = mid + 1;
        }
        else {
          end = mid - 1;
        }
      }
      // Either left side is sorted or right side is unsorted
      else if (nums[mid] > nums[start] || nums[mid] > nums[end]) {
        if (target < nums[mid] && target >= nums[start]) {
          end = mid - 1;
        }
        else {
          start = mid + 1;
        }
      }
      else {
        end--;
      }
    }
    return false;
  }   
}
