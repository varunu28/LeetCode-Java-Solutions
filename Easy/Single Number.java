class Solution {
  public int singleNumber(int[] nums) {
    int xor = nums[0];
    for (int i = 1; i < nums.length; i++) {
      xor ^= nums[i];
    }
    return xor;
  }
}
