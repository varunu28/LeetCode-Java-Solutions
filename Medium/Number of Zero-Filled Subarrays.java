class Solution {
  public long zeroFilledSubarray(int[] nums) {
    long count = 0;
    long subarrayLength = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        count += ++subarrayLength;
      } else {
        subarrayLength = 0;
      }
    }
    return count;
  }
}
