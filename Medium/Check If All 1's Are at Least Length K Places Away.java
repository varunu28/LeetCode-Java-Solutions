class Solution {
  public boolean kLengthApart(int[] nums, int k) {
    for (int start = -1, idx = 0; idx < nums.length; idx++) {
      if (nums[idx] == 1) {
        if (start != -1 && idx - start - 1 < k) {
          return false;
        }
        start = idx;
      }
    }
    return true;
  }
}
