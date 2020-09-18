class Solution {
  public int getMaxLen(int[] nums) {
    int startIndex = -1;
    int firstNegativeIndex = -1;
    int negativeCount = 0;
    int maxLen = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < 0) {
        negativeCount++;
        if (firstNegativeIndex == -1) {
          firstNegativeIndex = i;
        }
      }
      else if (nums[i] == 0) {
        negativeCount = 0;
        firstNegativeIndex = -1;
        startIndex = i;
      }
      maxLen = Math.max(
        maxLen, (negativeCount % 2 == 0 ? i - startIndex : i - firstNegativeIndex)
      );
    }
    return maxLen;
  }
}
