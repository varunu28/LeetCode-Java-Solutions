class Solution {
  public int maxAbsoluteSum(int[] nums) {
    int currMax = nums[0]; 
    int max = currMax; 
    int currMin = nums[0];
    int min = currMin;
    for(int i = 1; i < nums.length; i++){
        currMax = Math.max(nums[i], currMax + nums[i]);
        max = Math.max(max, currMax);
        currMin = Math.min(nums[i], currMin + nums[i]);
        min = Math.min(min, currMin);
    }
    return Math.max(max, Math.abs(min));
  }
}
