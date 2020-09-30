class Solution {
  public int firstMissingPositive(int[] nums) {
    int n = nums.length;
    int idx = 0;
    while (idx < n) {
      if (nums[idx] > 0 && nums[idx] < n && nums[nums[idx]] != nums[idx]) {
        swap(nums, idx, nums[idx]);
      }
      else {
        idx++;
      }
    }
    idx = 1;
    while (idx < n && nums[idx] == idx) {
      idx++;
    }
    if (n == 0 || idx < n) {
      return idx;
    }
    return nums[0] == idx ? idx + 1 : idx;
  }
  
  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
