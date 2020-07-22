class Solution {
  public int removeDuplicates(int[] nums) {
    int start = 0;
    int end = 0;
    int n = nums.length;
    while (end < n) {
      int curr = nums[end];
      while (end < n && nums[end] == curr) {
        end++;
      }
      nums[start++] = curr;
    }
    return start;
  }
}
