class Solution {
  public int minMoves2(int[] nums) {
    Arrays.sort(nums);
    int sum = 0;
    int start = 0;
    int end = nums.length - 1;
    while (start < end) {
      sum += nums[end--] - nums[start++];
    }
    return sum;
  }
}
