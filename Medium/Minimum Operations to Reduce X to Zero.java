class Solution {
  public int minOperations(int[] nums, int x) {
    int totalSum = 0;
    for (int num : nums) {
      totalSum += num;
    }
    int max = -1;
    int left = 0;
    int current = 0;
    for (int right = 0; right < nums.length; right++) {
      current += nums[right];
      while (current > totalSum - x && left <= right) {
        current -= nums[left++];
      }
      if (current == totalSum - x) {
        max = Math.max(max, right - left + 1);
      }
    }
    return max != -1 ? nums.length - max : -1;
  }
}
