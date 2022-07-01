class Solution {
  public int removeDuplicates(int[] nums) {
    int startIdx = 0;
    int endIdx = 0;
    while (endIdx < nums.length) {
      int currValue = nums[endIdx];
      while (endIdx < nums.length && nums[endIdx] == currValue) {
        endIdx++;
      }
      nums[startIdx++] = currValue;
    }
    return startIdx;
  }
}
