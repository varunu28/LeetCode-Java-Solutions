class Solution {
  
  private static enum DIRECTION {
    LEFT, RIGHT;
  }
  
  public boolean isMajorityElement(int[] nums, int target) {
    int rightIdx = getIndex(nums, target, DIRECTION.RIGHT);
    int leftIdx = getIndex(nums, target, DIRECTION.LEFT);
    if (leftIdx == -1 || rightIdx == -1) {
      return false;
    }
    int occurrences = rightIdx - leftIdx + 1;
    return occurrences > nums.length / 2;
  }
  
  private int getIndex(int[] nums, int target, DIRECTION direction) {
    int resultIdx = -1;
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[mid] == target) {
        resultIdx = mid;
        if (direction == DIRECTION.LEFT) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return resultIdx;
  }
}
