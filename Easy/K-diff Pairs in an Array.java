class Solution {
  public int findPairs(int[] nums, int k) {
    Arrays.sort(nums);
    int left = 0;
    int right = 1;
    int count = 0;
    while (left < nums.length && right < nums.length) {
      if (left == right || nums[right] - nums[left] < k) {
        right++;
      }
      else if (nums[right] - nums[left] > k) {
        left++;
      }
      else {
        left++;
        count++;
        while (left < nums.length && nums[left] == nums[left - 1]) {
          left++;
        }
      }
    }
    return count;
  }
}
