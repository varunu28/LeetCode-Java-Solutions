class Solution {
  public int maximumProduct(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    int rightSideProd = nums[n - 1] * nums[n - 2] * nums[n - 3];
    int leftSideProd = nums[0] * nums[1] * nums[2];
    int mixedSideProd = nums[0] * nums[1] * nums[n - 1];
    return Math.max(rightSideProd, Math.max(leftSideProd, mixedSideProd));
  }
}
