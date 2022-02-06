class Solution {
  public int removeDuplicates(int[] nums) {
    int startIdx = 0;
    int n = nums.length;
    int currIdx = 0;
    while (currIdx < n) {
      int currValue = nums[currIdx];
      int count = 0;
      while (currIdx < n && nums[currIdx] == currValue) {
        currIdx++;
        count++;
      }
      for (int i = 0; i < Math.min(2, count); i++) {
        nums[startIdx++] = currValue;
      }
    }
    return startIdx;
  }
}
