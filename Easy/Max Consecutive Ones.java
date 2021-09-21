class Solution {
  public int findMaxConsecutiveOnes(int[] nums) {
    int maxCount = 0;
    for (int i = 0; i < nums.length; ) {
      if (nums[i] == 1) {
        int currIdx = i;
        while (i < nums.length && nums[i] == 1) {
          i++;
        }
        maxCount = Math.max(maxCount, i - currIdx);
      }
      i++;
    }
    return maxCount;
  }
}
