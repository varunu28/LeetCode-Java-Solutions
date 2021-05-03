class Solution {
  public int[] runningSum(int[] nums) {
    int[] ans = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      ans[i] = nums[i] + (i == 0 ? 0 : ans[i - 1]);
    }
    return ans;
  }
}
