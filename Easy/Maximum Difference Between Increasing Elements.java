class Solution {
  public int maximumDifference(int[] nums) {
    int currMin = nums[0];
    int maxDiff = -1;
    for (int i = 0; i < nums.length; i++) {
      currMin = Math.min(currMin, nums[i]);
      if (nums[i] != currMin) {
        maxDiff = Math.max(maxDiff, nums[i] - currMin);
      }
    }
    return maxDiff;
  } 
}
