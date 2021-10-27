class Solution {
  public void sortColors(int[] nums) {
    int zeroIdx = 0;
    int twoIdx = nums.length - 1;
    int currIdx = 0;
    while (currIdx <= twoIdx) {
      if (nums[currIdx] == 0) {
        swap(nums, currIdx++, zeroIdx++);
      } else if (nums[currIdx] == 2) {
        swap(nums, currIdx, twoIdx--);
      } else {
        currIdx++;
      }
    }
  }
  
  private void swap(int[] nums, int idxOne, int idxTwo) {
    int temp = nums[idxTwo];
    nums[idxTwo] = nums[idxOne];
    nums[idxOne] = temp;
  }
}
