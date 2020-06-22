class Solution {
  public int singleNumber(int[] nums) {
    int seenOnce = 0;
    int seenTwice = 0;
    for (int num : nums) {
      seenOnce = ~seenTwice & (seenOnce ^ num);
      seenTwice = ~seenOnce & (seenTwice ^ num);
    }
    return seenOnce;
  }
}
