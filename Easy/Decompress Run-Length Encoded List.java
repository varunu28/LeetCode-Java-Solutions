class Solution {
  public int[] decompressRLElist(int[] nums) {
    int count = 0;
    for (int i = 0; i < nums.length; i += 2) {
      count += nums[i];
    }
    int idx = 0;
    int[] ans = new int[count];
    for (int i = 1; i < nums.length; i+= 2) {
      int freq = nums[i - 1];
      int val = nums[i];
      while (freq-- > 0) {
        ans[idx++] = val;
      }
    }
    return ans;
  }
}
