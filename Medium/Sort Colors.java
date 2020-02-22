class Solution {
  public void sortColors(int[] nums) {
    int zeroIdx = 0;
    int curr = 0;
    int n = nums.length - 1;
    int twoIdx = n;
    while (curr <= twoIdx) {
      if (nums[curr] == 0) {
        swap(nums, curr++, zeroIdx++);
      }
      else if (nums[curr] == 2) {
        swap(nums, curr, twoIdx--);
      }
      else {
        curr++;
      }
    }
  }
  
  private void swap(int[] nums, int idx1, int idx2) {
    int temp = nums[idx1];
    nums[idx1] = nums[idx2];
    nums[idx2] = temp;
  }
}
