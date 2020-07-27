class Solution {
  public int findLengthOfLCIS(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int maxLength = 1;
    int currCount = 1;
    int n = nums.length;
    for (int i = 1; i < n; i++) {
      if (nums[i] > nums[i - 1]) {
        currCount++;
      }
      else {
        maxLength = Math.max(maxLength, currCount);
        currCount = 1;
      }
    }
    return Math.max(maxLength, currCount);
  }
}
