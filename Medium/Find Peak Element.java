class Solution {
  public int findPeakElement(int[] nums) {
    return helper(nums, 0, nums.length - 1);
  }
  
  private int helper(int[] nums, int startIdx, int endIdx) {
    if (startIdx == endIdx) {
      return startIdx;
    }
    int midIdx = (startIdx + endIdx) / 2;
    int nextToMid = midIdx + 1;
    if (nums[midIdx] > nums[nextToMid]) {
      return helper(nums, startIdx, midIdx);
    } else {
      return helper(nums, nextToMid, endIdx);
    }
  }
}
