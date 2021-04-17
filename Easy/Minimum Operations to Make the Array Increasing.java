class Solution {
  public int minOperations(int[] nums) {
    int prev = nums[0];
    int totalOperations = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] <= prev) {
        totalOperations += prev - nums[i] + 1;
        prev++;
      } else {
        prev = nums[i];
      }
    }
    return totalOperations;
  }
}
