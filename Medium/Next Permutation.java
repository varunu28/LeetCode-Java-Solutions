class Solution {
  public void nextPermutation(int[] nums) {
    if (nums.length <= 1) {
      return;
    }
    int idx = nums.length - 2;
    while (idx >= 0 && nums[idx] >= nums[idx + 1]) {
      idx--;
    }
    if (idx >= 0) {
      int endIdx = nums.length - 1;
      while (nums[endIdx] <= nums[idx]) {
        endIdx--;
      }
      swap(nums, idx, endIdx);
    }
    int startIdx = idx + 1;
    int endIdx = nums.length - 1;
    while (startIdx < endIdx) {
      swap(nums, startIdx++, endIdx--);
    }
  }
  
  private void swap(int[] nums, int idxOne, int idxTwo) {
    int temp = nums[idxOne];
    nums[idxOne] = nums[idxTwo];
    nums[idxTwo] = temp;
  }
}
