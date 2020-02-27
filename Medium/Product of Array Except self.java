class Solution {
  public int[] productExceptSelf(int[] nums) {
    int[] ans = new int[nums.length];
    int mul = 1;
    for (int i = 0; i < nums.length; i++) {
      ans[i] = mul;
      mul *= nums[i];
    }
    mul = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      ans[i] *= mul;
      mul *= nums[i];
    }
    return ans;
  }
}
