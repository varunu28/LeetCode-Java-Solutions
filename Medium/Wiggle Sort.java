class Solution {
  public void wiggleSort(int[] nums) {
    boolean small = true;
    for (int i = 0; i < nums.length - 1; i++) {
      if (small) {
        if (nums[i] > nums[i + 1]) {
          swap(nums, i, i + 1);
        }
      }
      else {
        if (nums[i] < nums[i + 1]) {
          swap(nums, i, i + 1);
        }
      }
      small = !small;
    }
  }
  
  private void swap(int[] nums, int idx1, int idx2) {
    int temp = nums[idx2];
    nums[idx2] = nums[idx1];
    nums[idx1] = temp;
  }
}
