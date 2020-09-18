class Solution {
  public int missingElement(int[] nums, int k) {
    int n = nums.length;
    if (k > missing(n - 1,  nums)) {
      return nums[n - 1] + k - missing(n - 1, nums);
    }
    int start = 0;
    int end = n - 1;
    while (start < end) {
      int mid = start + (end - start) / 2;
      if (missing(mid, nums) < k) {
        start = mid + 1;
      }
      else {
        end = mid;
      }
    }
    return nums[start - 1] + k - missing(start - 1, nums);
  }
  
  private int missing(int idx, int[] nums) {
    return nums[idx] - nums[0] - idx;
  }
}
