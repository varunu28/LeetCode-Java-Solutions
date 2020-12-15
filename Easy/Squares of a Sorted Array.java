class Solution {
  public int[] sortedSquares(int[] nums) {
    int n = nums.length;
    int[] squareSorted = new int[n];
    int start = 0;
    while (start < n && nums[start] < 0) {
      start++;
    }
    int end = start;
    start -= 1;
    int idx = 0;
    while (start >= 0 || end < n) {
      if (start >= 0 && end < n) {
        if (nums[start] * nums[start] > nums[end] * nums[end]) {
          squareSorted[idx++] = nums[end] * nums[end++];
        } else {
          squareSorted[idx++] = nums[start] * nums[start--];
        }
      } else if (start >= 0) {
        squareSorted[idx++] = nums[start] * nums[start--];
      } else {
          squareSorted[idx++] = nums[end] * nums[end++];
      }
    }
    return squareSorted;
  }
}
