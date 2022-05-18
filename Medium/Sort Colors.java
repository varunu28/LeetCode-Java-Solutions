class Solution {
  public void sortColors(int[] nums) {
    int zeroIdx = 0;
    int twoIdx = nums.length - 1;
    for (int i = 0; i <= twoIdx; ) {
      if (nums[i] == 0 && i != zeroIdx) {
        int temp = nums[zeroIdx];
        nums[zeroIdx++] = nums[i];
        nums[i] = temp;
      } else if (nums[i] == 2 && i != twoIdx) {
        int temp = nums[twoIdx];
        nums[twoIdx--] = nums[i];
        nums[i] = temp;
      } else {
        i++;
      }
    }
  }
}
