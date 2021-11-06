class Solution {
  public int[] singleNumber(int[] nums) {
    int xorValue = Integer.highestOneBit(Arrays.stream(nums)
        .boxed()
        .reduce((a, b) -> a ^ b)
        .orElse(0));
    int[] result = new int[2];
    for (int num : nums) {
      if ((xorValue & num) == 0) {
        result[0] ^= num;
      } else {
        result[1] ^= num;
      }
    }
    return result;
  }
}
