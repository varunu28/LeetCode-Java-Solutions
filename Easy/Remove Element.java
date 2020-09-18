class Solution {
  public int removeElement(int[] nums, int val) {
    int start = 0;
    int end = 0;
    int n = nums.length;
    while (end < n) {
      if (nums[end] != val) {
        nums[start++] = nums[end];
      }
      end++;
    }
    return start;
  }
}
