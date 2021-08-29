class Solution {
  public int minimumDifference(int[] nums, int k) {
    Arrays.sort(nums);
    int left = 0;
    int right = k - 1;
    int minDiff = Integer.MAX_VALUE;
    while (right < nums.length) {
      minDiff = Math.min(minDiff, nums[right++] - nums[left++]);
    }
    return minDiff;
  }
}
