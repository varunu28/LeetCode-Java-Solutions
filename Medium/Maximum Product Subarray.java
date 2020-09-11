class Solution {
  public int maxProduct(int[] nums) {
    int currMax = nums[0];
    int currMin = nums[0];
    int maxProd = currMax;
    for (int i = 1; i < nums.length; i++) {
      int temp = currMax;
      currMax = Math.max(Math.max(temp * nums[i], currMin * nums[i]), nums[i]);
      currMin = Math.min(Math.min(temp * nums[i], currMin * nums[i]), nums[i]);
      maxProd = Math.max(maxProd, currMax);
    }
    return maxProd;
  }
}
